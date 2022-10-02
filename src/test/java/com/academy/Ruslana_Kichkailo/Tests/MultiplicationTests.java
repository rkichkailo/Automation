package com.academy.Ruslana_Kichkailo.Tests;
import com.academy.Ruslana_Kichkailo.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTests extends DataProviderForTests{

    @Test(dataProvider = "numbers_toMultiply")
    public void testMultiplyTwoNumbers(double number1, double number2){
        Assert.assertEquals(Calculator.multiply(number1,number2),14);
    }
    @Test
    public void testMultiplyNumberByZero(){
        Assert.assertEquals(Calculator.multiply(27, 0),0);
        Assert.assertEquals(Calculator.multiply(27.7, 0),0);
        Assert.assertEquals(Calculator.multiply(-27, 0),0);
        Assert.assertEquals(Calculator.multiply(-27.7, 0),0);
        Assert.assertEquals(Calculator.multiply(0, 0),0);
    }
}
