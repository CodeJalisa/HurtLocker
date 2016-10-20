package Hewitt.Jalisa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

/**
 * Created by jalisahewitt on 10/17/16.
 */
public class GroceryListTest {

    GroceryList groceryList;
    @Before

    public void setUp(){
        groceryList = new GroceryList("name:Jalisa;LastName:Hewitt;Age:22##name:Anthony;LastName:Hewitt;Age:18##name:Jackson;LastName:Hewitt;Age:4");
    }

    @Test
    public void SplittingTest(){
        groceryList.Spliting();
        String expected = "name:Jalisa;LastName:Hewitt;Age:22";
        String[] object1 = groceryList.getObject();
        String actual = object1[0];
        assertEquals("Split original String by the hash tags", expected, actual);

    }

    @Test
    public void SplittingTest2(){
        groceryList.Spliting();
        String expected = "name:Anthony;LastName:Hewitt;Age:18";
        String[] object1 = groceryList.getObject();
        String actual = object1[1];
        assertEquals("Split original String by the hash tags", expected, actual);

    }



    @Test
    public void SecondSplitTest(){
        groceryList.Spliting();
        groceryList.SecondSplit();
        String expected = "Jalisa";
        String actual = groceryList.getGroceryDeatils().get(0);
        assertEquals("Need to log only name", expected, actual);
    }

    @Test
    public void SecondSplitTest2(){
        groceryList.Spliting();
        groceryList.SecondSplit();
        String expected = "Anthony";
        String actual = groceryList.getGroceryDeatils().get(1);
        assertEquals("Need to log only name", expected, actual);
    }

    @Test
    public void FindNameTest(){
        String expected= "Milk";
        String actual = groceryList.FindName('M');
        assertEquals("M should turn into milk", expected, actual);
    }
    
}
