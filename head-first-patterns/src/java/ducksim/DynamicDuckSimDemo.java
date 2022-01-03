package ducksim;

import ducksim.ducks.Duck;
import ducksim.ducks.MallardDuck;
import ducksim.ducks.RubberDuck;
import ducksim.quacking.Quack;

/**
 * Example of behavior encapsulation on ducks (Pattern Strategy).
 *
 * This is a dynamic version meaning that we can change duck behavior in run-time.
 *
 * @author ahalikov
 */
public class DynamicDuckSimDemo {

    public static void main(String[] args) {

        // Default behavior
        Duck duck1 = new MallardDuck();
        duck1.performFly();
        duck1.performQuack();

        Duck duck2 = new RubberDuck();
        duck2.performFly();
        duck2.performQuack();

        // New behavior of RubberDuck
        duck2.setQuackBehavior(new Quack());
        duck2.performQuack();
    }
}
