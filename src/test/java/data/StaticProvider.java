package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForCheckoutForm")
    public static Object[][] dataForCheckoutForm() {
        return new Object[][]{
                {29},
                {30},
                {31}
        };
    }
}