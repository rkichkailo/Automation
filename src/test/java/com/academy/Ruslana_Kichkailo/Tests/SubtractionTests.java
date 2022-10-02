package com.academy.Ruslana_Kichkailo.Tests;
import com.academy.Ruslana_Kichkailo.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTests extends DataProviderForTests{

    @Test(dataProvider = "numbers_toSubtract")
    public void testSubtractTwoNumbers(double number1, double number2){
        Assert.assertEquals(Calculator.subtract(number1,number2),0);
    }
}
