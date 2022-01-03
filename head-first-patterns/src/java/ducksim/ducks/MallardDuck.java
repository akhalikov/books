package ducksim.ducks;

import ducksim.flying.FlyWithWings;
import ducksim.quacking.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("Displaying a mallard duck");
    }
}
