package com.academy.Ruslana_Kichkailo.Tests;

import com.academy.Ruslana_Kichkailo.DataCheck;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CorrectDataCheckTests extends DataProviderForTests{

    @Test(dataProvider = "correctOperator")
    public void testCorrectOperator(String operator){
        assertTrue(DataCheck.checkOperator(operator));
    }
}
