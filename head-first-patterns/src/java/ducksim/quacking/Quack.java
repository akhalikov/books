package ducksim.quacking;

import ducksim.ducks.Duck;

public class Quack implements QuackBehavior {

    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getClass().getSimpleName() + ": Quack!");
    }
}
