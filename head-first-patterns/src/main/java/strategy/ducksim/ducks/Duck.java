package strategy.ducksim.ducks;

import strategy.ducksim.flying.FlyBehavior;
import strategy.ducksim.quacking.QuackBehavior;

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