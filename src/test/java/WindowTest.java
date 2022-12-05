
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class WindowTest {
    @Test
    void test1()
    {
        ProductData pd = new ProductData();

        pd.addProduct("potato", "Belarus", 5);
        pd.addProduct("apple", "America",2);
        pd.addProduct("grapes", "Belarus",5);
        pd.addProduct("orange", "China",7);
        List<String> actual = pd.getNamesByProdCount();
        List<String> expected= List.of(new String[]{"apple", "grapes", "potato", "orange"});
        assertEquals(expected, actual);
    }

    @Test
    void test2()
    {
        ProductData pd = new ProductData();

        pd.addProduct("milk", "Belarus", 18);
        pd.addProduct("cheese", "America",13);
        pd.addProduct("kefir", "Australia",14);
        pd.addProduct("bread", "Germany",6);
        List<String> actual = pd.getNamesByProdCount();
        List<String> expected= List.of(new String[]{"bread", "cheese", "kefir", "milk"});
        assertEquals(expected, actual);
    }

}
