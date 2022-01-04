package strategy.ducksim.quacking;

import strategy.ducksim.ducks.Duck;

public class Squeak implements QuackBehavior {

    @Override
    public void quack(Duck duck) {
        System.out.println(duck.getClass().getSimpleName() + ": Squeak squeak!");
    }
}
