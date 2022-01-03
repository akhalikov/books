package ducksim.quacking;

import ducksim.ducks.Duck;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack(Duck duck) {
        // no sound
        System.out.println(duck.getClass().getSimpleName() + ": << silence >>");
    }
}
