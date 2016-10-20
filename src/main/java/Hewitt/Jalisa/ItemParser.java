package Hewitt.Jalisa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jalisahewitt on 10/18/16.
 */
public class ItemParser {
    List<String[]> groceryItem = new ArrayList<String[]>();
    String name;
    String price;
    Map<String, String> groceryItemsAndPrices = new HashMap<String, String>();
    Pattern namePattern = Pattern.compile("B|b|M|C|a");
    Matcher m;
    Pattern pricePattern = Pattern.compile("\\d...");


    public ItemParser(ArrayList<String> object) {
        for (int i = 0; i < object.size(); i+=2) {
            name = object.get(i);
            for(int j=i+1; j<object.size(); j++){
                    price = object.get(i);
                    groceryItemsAndPrices.put(name , price );

            }
        }

    }
//        for (int i = 0; i < object.size(); i++) {
//
//
//
//        }



    public List<String[]> getGroceryItem(){
        return groceryItem;
    }

    public Map<String, String> getGroceryItemsAndPrices() {
        System.out.println(groceryItemsAndPrices);
        return groceryItemsAndPrices;
    }
}
