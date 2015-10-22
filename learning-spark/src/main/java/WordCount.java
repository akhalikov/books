import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Example 2-10. Word count Java application
 */
public class WordCount {

    public static void main(String[] args) {
        if (args.length < 2)
            throw new IllegalArgumentException("Expecting input and output file names");

        final String inputFile = args[0];
        final String outputFile = args[1];

        System.out.println("Processing file: " + inputFile);

        // Create Spark context

        SparkConf conf = new SparkConf().setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Load input data
        JavaRDD<String> input = sc.textFile(inputFile);

        // Split up into words
        JavaRDD<String> words = input.flatMap(
                new FlatMapFunction<String, String>() {
                    public Iterable<String> call(String x) {
                        return Arrays.asList(x.split(" "));
                    }
                });

        // Transform into pairs and count
        JavaPairRDD<String, Integer> counts = words.mapToPair(
                new PairFunction<String, String, Integer>(){
                    public Tuple2<String, Integer> call(String x){
                        return new Tuple2(x, 1);
                    }}).reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer x, Integer y) {
                return x + y;
            }
        });

        System.out.println("Saving result to: " + outputFile);
        counts.saveAsTextFile(outputFile);
    }
}
