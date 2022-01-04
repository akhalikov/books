package strategy.ducksim.flying;

import strategy.ducksim.ducks.Duck;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly(Duck duck) {
        // can't fly
        System.out.println(duck.getClass().getSimpleName() + ": I can't fly :(");
    }
}
