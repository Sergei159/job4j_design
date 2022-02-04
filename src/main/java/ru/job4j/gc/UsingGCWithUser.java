package ru.job4j.gc;

public class UsingGCWithUser {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();


    public static long info() {
        long freeMemory = ENVIRONMENT.freeMemory();
        long totalMemory = ENVIRONMENT.totalMemory();
        long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / KB);
        System.out.printf("Total: %d%n", totalMemory / KB);
        System.out.printf("Max: %d%n", maxMemory / KB);
        return freeMemory;
    }


    public static void main(String[] args) {

        long startMemory = info();
        for (int i = 1; i <= 10; i++) {
            new User(i, "N" + i);
        }
        long afterTenUsersMemory = info();
        System.out.printf("Ten users take up %d KB %n",
                (startMemory - afterTenUsersMemory) / KB);

        System.out.println("-Xmx4m -Xms4m");
        for (int i = 11; i <= 3000; i++) {
            new User(i, "N" + i);
        }
    }

}
