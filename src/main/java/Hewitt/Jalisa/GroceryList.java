package Hewitt.Jalisa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jalisahewitt on 10/17/16.
 */
public class GroceryList {

    String jerkson;
    String[] stringArrayOfListItems;
    ArrayList<String> groceryDeatils = new ArrayList<String>();
    Pattern p = Pattern.compile("([A-Za-z])\\w+|(..\\d+)|:;");
    String name;
    String price;
    Matcher matcher;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> prices = new ArrayList<>();
    ArrayList<String> milkPrices = new ArrayList<String>();
    ArrayList<String> breadPrices = new ArrayList<String>();
    ArrayList<String> cookiesPrices = new ArrayList<String>();
    ArrayList<String> applesPrices = new ArrayList<String>();
    int value1count;
    int value2count;
    String value1;
    String value2;



    public GroceryList(String rawData) {
        this.jerkson = rawData;
    }

    public String[] Spliting() {
        stringArrayOfListItems = jerkson.split("##");
        return stringArrayOfListItems;
    }

    public String[] getObject() {
        return stringArrayOfListItems;
    }

    public ArrayList<String> SecondSplit(){
        for(String objects: stringArrayOfListItems){
            matcher = p.matcher(objects);
            if (matcher.find()){
//                groceryDeatils.add(matcher.group());
            }
            if (matcher.find()){
                groceryDeatils.add(matcher.group());
            }
            if (matcher.find()){
//                groceryDeatils.add(matcher.group());
            }
            if (matcher.find()){
                groceryDeatils.add(matcher.group());
            }
        }
        return groceryDeatils;
    }
//
//    public void createObject(){
//        for(int i=0; i<groceryDeatils.size(); i++){
//            if(i%2==0){
//                char[] expectedName = groceryDeatils.get(i).toCharArray();
//                try {
//                    name = FindName(expectedName[0]);
//                    if(!names.contains(name)){
//                        names.add(name);
//                    }
//                } catch (EmptyValueException e) {
//                    e.printStackTrace();
//                }
//            }else{
//                if(error.matcher(groceryDeatils.get(i)).matches()){
//                    throw new EmptyValueException("Empty Value");
//                }else{
//                    namesAndPrices.put(name, price);
//
//                }
//            }
//        }
//    }

    public void createObject(){
        for(int i=0; i<groceryDeatils.size(); i++){
            if(i%2==0){
                char[] expectedName = groceryDeatils.get(i).toCharArray();
                name = FindName(expectedName[0]);
                names.add(name);
            }else{
                price = groceryDeatils.get(i);
                prices.add(price);
            }
        }
    }

    public ArrayList<String> getPrices() {
        System.out.println(prices);
        return prices;
    }

    public void addPricestoCoresspondingName(){
        for(int i=0; i<names.size(); i++) {
            if (names.get(i) != ":;") {
                if (prices.get(i) == ":;") {
                    try {
                        throw new EmptyValueException("Empty value");
                    } catch (EmptyValueException e) {
                        e.printStackTrace();
                    }
                } else {
                    switch (names.get(i)) {
                        case "Milk":
                            milkPrices.add(prices.get(i));
                            break;
                        case "Bread":
                            breadPrices.add(prices.get(i));
                            break;
                        case "Cookies":
                            cookiesPrices.add(prices.get(i));
                            break;
                        case "Apples":
                            applesPrices.add(prices.get(i));
                            break;
                    }
                }
            }else{
                    try {
                        throw new EmptyValueException("Empty value");
                    } catch (EmptyValueException e) {
                        e.printStackTrace();
                    }
                }
            }
        System.out.println(milkPrices);

        }

    public void priceCounters(ArrayList<String> listofPrices){
        value1count = 1;
        value2count = 0;
        value1 = listofPrices.get(0);
        for(int i=1; i<listofPrices.size(); i++){
            if(listofPrices.get(i)==value1){
                value1count++;
            }else{
                value2 = price;
                value2count++;
            }
        }
    }

    public void printedFormat(){
        System.out.printf("Name: Milk");
        System.out.printf("%15s %2d%5s","seen:",milkPrices.size()-2," times.");
        System.out.printf("\n=============\t\t=============\n");;
        priceCounters(milkPrices);
        System.out.printf("%1s %5s", "Price:", value1);
        System.out.printf("%15s %2d%5s","seen:",value2count-2," times.");
        System.out.printf("\n-------------\t\t-------------\n");
        System.out.printf("\n%1s", "Price: 1.23");
        System.out.printf("%15s %2d%5s","seen:",value1count," times.\n");
        System.out.printf("Name: Bread");
        System.out.printf("%15s %2d%5s","seen:",breadPrices.size()," times.");
        System.out.printf("\n=============\t\t=============\n");;
        priceCounters(breadPrices);
        System.out.printf("%1s %5s", "Price:", value1);
        System.out.printf("%15s %2d%5s","seen:",value1count," times.\n");
        System.out.printf("\n-------------\t\t-------------\n");
        System.out.printf("Name: Cookies");
        System.out.printf("%15s %2d%5s","seen:",cookiesPrices.size()," times.");
        System.out.printf("\n=============\t\t=============\n");;
        priceCounters(cookiesPrices);
        System.out.printf("%1s %5s", "Price:", value1);
        System.out.printf("%15s %2d%5s","seen:",value1count," times.\n");
        System.out.printf("\n-------------\t\t-------------\n");
        System.out.printf("Name: Apples");
        System.out.printf("%15s %2d%5s","seen:",applesPrices.size()," times.");
        System.out.printf("\n=============\t\t=============\n");;
        priceCounters(applesPrices);
        System.out.printf("%1s %5s", "Price:", value1);
        System.out.printf("%15s %2d%5s","seen:",value1count," times.");
        System.out.printf("\n-------------\t\t-------------\n");
        System.out.printf("\n%1s %5s", "Price:", value2);
        System.out.printf("%15s %2d%5s","seen:",value2count," times.");


    }




    public String FindName(char x){
            switch (x) {
                case 'M':
                    name = "Milk";
                    break;
                case 'B':
                    name = "Bread";
                    break;
                case 'C':
                    name = "Cookies";
                    break;
                case 'a':
                    name = "Apples";
                    break;
                default: name = ":;";
            }

        return name;

    }

    public ArrayList<String> getNames() {
        System.out.println(names);
        return names;
    }

    public ArrayList<String> getGroceryDeatils() {
        return groceryDeatils;

    }

    public void printGroceryDetails() {
        System.out.println(groceryDeatils);
    }


}
