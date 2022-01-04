package strategy.ducksim.flying;

import strategy.ducksim.ducks.Duck;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly(Duck duck) {
        System.out.println(duck.getClass().getSimpleName() + ": Yay! I am flying with the wings");
    }
}
