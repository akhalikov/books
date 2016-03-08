package chapter15;

import java.util.concurrent.Semaphore;

/**
 * Class Foo has three methods: first(), second(), and third().
 * threadA will call first(), threadB will call second(), and threadC will call third().
 * Design a mechanism to ensure that first() is called before second(),
 * and second() is called before third().
 *
 */
public class CallInOrder {
  public static void main(String[] args) throws Exception {
    final Foo foo = new Foo();

    Thread threadA = new Thread(() -> foo.first(), "threadA");
    Thread threadB = new Thread(() -> foo.second(), "threadB");
    Thread threadC = new Thread(() -> foo.third(), "threadC");

    threadA.start();
    threadB.start();
    threadC.start();
  }

  static final class Foo {
    private Semaphore sem1, sem2;

    public Foo() throws InterruptedException {
      sem1 = new Semaphore(1);
      sem2 = new Semaphore(1);

      sem1.acquire();
      sem2.acquire();
    }

    void first() {
      System.out.println(Thread.currentThread().getName() + ": first");
      sem1.release();
    }

    void second() {
      try {
        sem1.acquire();
        sem1.release();
        System.out.println(Thread.currentThread().getName() + ": second");
        sem2.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    void third() {
      try {
        sem2.acquire();
        sem2.release();
        System.out.println(Thread.currentThread().getName() + ": third");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
