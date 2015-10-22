#!/usr/bin/env bash

$SPARK_BIN/spark-submit --class WordCount ../target/learning-spark-1.jar $WORK/temp/README.md ../target/wordcounts