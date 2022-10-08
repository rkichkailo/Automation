package com.academy.Ruslana_Kichkailo.homework2.tests;
import com.academy.Ruslana_Kichkailo.homework2.DataCheck;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CorrectDataCheckTests extends DataProviderForTests {

    @Test(dataProvider = "correctOperator")
    public void testCorrectOperator(String operator){
        assertTrue(DataCheck.checkOperator(operator));
    }
}
