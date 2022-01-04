package strategy.ducksim;

import strategy.ducksim.ducks.MallardDuck;
import strategy.ducksim.ducks.RubberDuck;
import strategy.ducksim.quacking.Quack;

/**
 * Example of behavior encapsulation on ducks (Pattern Strategy).
 *
 * This is a dynamic version meaning that we can change duck behavior in run-time.
 *
 */
public class DynamicDuckSimDemo {

    public static void main(String[] args) {

        // Default behavior
        final var duck1 = new MallardDuck();
        duck1.performFly();
        duck1.performQuack();

        final var duck2 = new RubberDuck();
        duck2.performFly();
        duck2.performQuack();

        // New behavior of RubberDuck
        duck2.setQuackBehavior(new Quack());
        duck2.performQuack();
    }
}
