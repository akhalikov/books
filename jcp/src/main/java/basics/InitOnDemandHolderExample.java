package basics;

/**
 * Thread-safe Initialization On Demand Holder idiom
 *
 * This code is guaranteed to be correct because of the initialization guarantees for static fields;
 * if a field is set in a static initializer, it is guaranteed to be made visible, correctly,
 * to any thread that accesses that class.
 *
 * {@see https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html}
 */
class InitOnDemandHolderExample {

    static class Something {
        private static Something instance = null;

        public static Something getInstance() {
            return LazySomethingHolder.something;
        }

        // ...

        private static class LazySomethingHolder {
            public static Something something = new Something();
        }
    }
}
