package ducksim.ducks;

import ducksim.flying.FlyNoWay;
import ducksim.quacking.Squeak;

/**
 * A rubber duck class
 *
 * @author ahalikov
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("Displaying a rubber duck");
    }
}
