package com.academy.Ruslana_Kichkailo.Tests;

import com.academy.Ruslana_Kichkailo.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTests extends DataProviderForTests{
    @Test(dataProvider = "numbers_toDivide")
    public void testDivideTwoNumbers(double number1, double number2){
        Assert.assertEquals(Calculator.divide(number1,number2),3);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideNumberByZero_exceptionExpected(){
        Calculator.divide(29,0);
    }
}
