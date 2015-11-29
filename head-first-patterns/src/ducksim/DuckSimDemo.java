package ducksim;

import ducksim.ducks.Duck;
import ducksim.ducks.MallardDuck;
import ducksim.ducks.RubberDuck;

/**
 * Example of behavior encapsulation on ducks (Pattern Strategy).
 *
 * Mutable aspects are encapsulated into "behavior" classes FlyBehavior and QuackBehavior.
 * Concrete behavior implementation is assigned to ducks via constructors so
 * we can say that behavior is static.
 *
 * @author ahalikov
 */
public class DuckSimDemo {

    public static void main(String[] args) {
        Duck duck1 = new MallardDuck();
        duck1.performFly();
        duck1.performQuack();

        Duck duck2 = new RubberDuck();
        duck2.performFly();
        duck2.performQuack();
    }
}
