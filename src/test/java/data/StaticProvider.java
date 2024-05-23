package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "projectNumber")
    public static Object[][] projectNumber() {
        return new Object[][]{
                {29},
                {30},
                {31}
        };
    }
}