package chapter1;

/**
 * Default methods of interfaces
 *
 * @author ahalikov
 */
public class DefaultMethods {

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.getName());
    }

    interface Person {
        long getId();
        default String getName() { return "John Q. Public"; }
    }

    interface Named {
        default String getName() {
            return getClass().getName() + "_" + hashCode();
        }
    }

    // If getName() is removed, the compiler will fail
    // not knowing what getName() method to inherit
    static class Student implements Person, Named {
        @Override
        public long getId() {
            return 0;
        }

        @Override
        public String getName() {
            return null;
        }
    }
}
