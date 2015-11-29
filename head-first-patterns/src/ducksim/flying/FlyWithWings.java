package ducksim.flying;

import ducksim.ducks.Duck;

/**
 * @author ahalikov
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly(Duck duck) {
        System.out.println(duck.getClass().getSimpleName() + ": Yay! I am flying with the wings");
    }
}
