package Hewitt.Jalisa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jalisahewitt on 10/17/16.
 */
public class GroceryList {
    Main m = new Main();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    String jerkson;
    String[] stringArrayOfListItems;
    ArrayList<String> groceryDeatils = new ArrayList<String>();
    Pattern p = Pattern.compile("^.*?;");
    Matcher matcher;

    public GroceryList(String rawData){
        this.jerkson = rawData;
    }

    public String[] Spliting(){
        stringArrayOfListItems = jerkson.split("##");
        return stringArrayOfListItems;
    }

    public String[] getObject() {
        return stringArrayOfListItems;
    }

    public ArrayList<String> SplitNamesOff(){
        for(String objects: stringArrayOfListItems){
            matcher = p.matcher(objects);
            while(matcher.find()){
                groceryDeatils.add(matcher.group());
            }
        }
        return groceryDeatils;
    }

    public ArrayList<String> getGroceryDeatils() {
        return groceryDeatils;

    }

    public void printGroceryDetails(){
        System.out.println(groceryDeatils);
    }
}
