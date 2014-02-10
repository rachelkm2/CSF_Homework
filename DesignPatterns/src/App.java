/**
 * Created by rachelmann on 2/3/14.
 */
public class App {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}
