package Hewitt.Jalisa;

/**
 * Created by jalisahewitt on 10/17/16.
 */
public class EmptyValueException extends Exception{
    static int counter = 0;
    public EmptyValueException(String e){
        counter++;

    }
    public static String ErrorOutput(){
        return "Errors\t\t\t\tseen: "+counter+" times";
    }


}
