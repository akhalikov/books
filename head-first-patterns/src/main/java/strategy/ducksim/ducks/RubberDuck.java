package strategy.ducksim.ducks;

import strategy.ducksim.flying.FlyNoWay;
import strategy.ducksim.quacking.Squeak;

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
