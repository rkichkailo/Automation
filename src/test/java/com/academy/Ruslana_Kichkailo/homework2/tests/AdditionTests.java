package com.academy.Ruslana_Kichkailo.homework2.tests;
import com.academy.Ruslana_Kichkailo.homework2.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AdditionTests extends DataProviderForTests {

    @Test(dataProvider = "numbers_toAdd")
    public void testAddTwoNumbers(double number1, double number2){
        Assert.assertEquals(Calculator.add(number1,number2),9);
    }
}
