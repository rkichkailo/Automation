package com.academy.Ruslana_Kichkailo.Tests;
import com.academy.Ruslana_Kichkailo.DataCheck;
import org.testng.annotations.Test;

public class MenuFunctionSelectedTests extends DataProviderForTests{

    @Test(dataProvider = "numbers_incorrect", expectedExceptions = NumberFormatException.class)
    public void testUserChoiceDataInMenu(String number){
        DataCheck.checkMenuFunctionSelected(number);
    }
}
