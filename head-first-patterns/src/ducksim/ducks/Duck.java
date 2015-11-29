package ducksim.ducks;

import ducksim.flying.FlyBehavior;
import ducksim.quacking.QuackBehavior;

/**
 * A duck class
 *
 * @author ahalikov
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly(this);
    }

    public void performQuack() {
        quackBehavior.quack(this);
    }

    public void swim() {
        System.out.println("Swimming...");
    }

    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}