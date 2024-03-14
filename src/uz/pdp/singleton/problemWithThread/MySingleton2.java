package uz.pdp.singleton.problemWithThread;

public class MySingleton2 {
    private static final MySingleton2 instance = new MySingleton2();

    private MySingleton2() {
    }

    public static MySingleton2 getInstance() {
        return instance;
    }
}
