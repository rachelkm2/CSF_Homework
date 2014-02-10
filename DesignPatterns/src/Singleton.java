/**
 * Created by rachelmann on 2/3/14.
 */
public class Singleton {

    private static Singleton s;

    private Singleton(){

    }

    public static Singleton getInstance() {


        if (s == null){
            s = new Singleton();
        }

        //could also write the above as...
        
//        if (Singleton.s == null){
//            Singleton.s = new Singleton();
//        }

        return s;

    }



}
