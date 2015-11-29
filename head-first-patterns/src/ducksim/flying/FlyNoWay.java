package ducksim.flying;

import ducksim.ducks.Duck;

/**
 * @author ahalikov
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly(Duck duck) {
        // can't fly
        System.out.println(duck.getClass().getSimpleName() + ": I can't fly :(");
    }
}
