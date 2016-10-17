package Hewitt.Jalisa;

import org.apache.commons.io.IOUtils;

public class Main {
    String results;

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        this.results = result;
        return results;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        GroceryList g = new GroceryList(output);
        g.Spliting();
        g.SplitNamesOff();
        g.printGroceryDetails();

    }


}
