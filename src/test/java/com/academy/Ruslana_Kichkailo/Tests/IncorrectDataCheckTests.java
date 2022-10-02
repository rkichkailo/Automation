package com.academy.Ruslana_Kichkailo.Tests;

import com.academy.Ruslana_Kichkailo.DataCheck;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class IncorrectDataCheckTests extends DataProviderForTests{

    @Test(dataProvider = "operator")
    public void testIncorrectOperator(String operator){
        assertFalse(DataCheck.checkOperator(operator));
    }

    @Test(dataProvider = "numbers_incorrect", expectedExceptions = NumberFormatException.class)
    public void testIncorrectNumber(String number){
        DataCheck.checkNumber(number);
    }
}
