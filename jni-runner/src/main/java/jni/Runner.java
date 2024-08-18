package jni;

public class Runner {
    static Tools tools = new Tools();
    public static void main(String[] args) {
        System.out.printf("Runnin!");


        for (int i = 0; i < 20; i++) {
            performCpuTask();
        }

//        System.out.println(tools.bar());
    }

    private static void performCpuTask() {
        // Start a new thread to simulate CPU load
        Thread cpuLoadThread = new Thread(() -> {
            tools.bar(); // e-cores only, please
            while (true) {
                // Simulate CPU activity
                double load = 0;
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    load += Math.sqrt(i);
                }
                if(load < 0) {
                    return;
                }
            }
        });

        // Start the thread
        cpuLoadThread.start();
    }
}