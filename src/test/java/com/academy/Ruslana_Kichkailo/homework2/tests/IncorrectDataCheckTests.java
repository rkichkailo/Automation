package com.academy.Ruslana_Kichkailo.homework2.tests;

import com.academy.Ruslana_Kichkailo.homework2.DataCheck;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class IncorrectDataCheckTests extends DataProviderForTests {

    @Test(dataProvider = "operator")
    public void testIncorrectOperator(String operator){
        assertFalse(DataCheck.checkOperator(operator));
    }

    @Test(dataProvider = "numbers_incorrect", expectedExceptions = NumberFormatException.class)
    public void testIncorrectNumber(String number){
        DataCheck.checkNumber(number);
    }
}
