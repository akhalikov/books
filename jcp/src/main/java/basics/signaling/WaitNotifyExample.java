package basics.signaling;

import static toolkit.threads.ThreadHelper.clog;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyExample {
  private final List<String> sharedList = new ArrayList<>();

  private String removeElement() throws InterruptedException {

    synchronized (sharedList) {

      // while the list is empty, wait
      while (sharedList.isEmpty()) {
        clog("List is empty...");
        sharedList.wait();
        clog("Stop waiting...");
      }

      return sharedList.remove(0);
    }
  }

  private void addElement(String element) {
    clog("Opening...");
    synchronized (sharedList) {

      // add an element and notify all that an element exists
      sharedList.add(element);
      clog("New Element:'" + element + "'");

      sharedList.notifyAll();
      clog("notifyAll called!");
    }
    clog("Closing...");
  }

  public static void main(String[] args) {
    WaitNotifyExample demo = new WaitNotifyExample();

    Runnable runA = () -> {
      try {
        clog("" + demo.removeElement());
      } catch (InterruptedException ix) {
        clog("Interrupted Exception!");
      } catch (Exception x) {
        clog("Exception thrown.");
      }
    };

    // run adds an element in the list and starts the loop
    Runnable runB = () -> demo.addElement("Hello!");

    try {
      Thread threadA1 = new Thread(runA, "thread A");
      threadA1.start();

      Thread.sleep(500);

      Thread threadA2 = new Thread(runA, "thread B");
      threadA2.start();

      Thread.sleep(500);

      Thread threadB = new Thread(runB, "thread C");
      threadB.start();

      Thread.sleep(1000);

      threadA1.interrupt();
      threadA2.interrupt();

    } catch (InterruptedException e) {
      // e.printStackTrace();
    }
  }
}
