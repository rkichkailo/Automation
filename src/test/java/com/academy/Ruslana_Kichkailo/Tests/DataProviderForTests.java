package com.academy.Ruslana_Kichkailo.Tests;
import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "correctOperator")
    public Object[][] provideCorrectOperators_forDataCheck(){
        return new Object [][] {{"+"}, {"-"}, {"*"}, {"/"}};
    }

    @DataProvider(name = "operator")
    public Object[][] provideIncorrectOperators_forDataCheck(){
        return new Object [][] {{"test"}, {"123"}, {"_"}, {"="}, {"x"}};
    }

    @DataProvider(name = "numbers_incorrect")
    public Object[][] provideIncorrectNumbers_forDataCheck(){
        return new Object [][] {{"test"}, {"!@#"}, {"1.o"}, {"o.1"}, {"o"}, {" "}, {""}, {"null"}};
    }

    @DataProvider(name = "numbers_toAdd")
    public Object[][] provideCorrectNumbers_toAdd(){
        return new Object [][] {{5.5, 3.5}, {5, 4}, {-1,10}, {11, -2},
                                {9, 0}, {0,9}, {11.5, -2.5}, {-2.5, 11.5}};
    }

    @DataProvider(name = "numbers_toSubtract")
    public Object[][] provideCorrectNumbers_toSubtract(){
        return new Object [][] {{5.5, 5.5}, {5, 5}, {-5.5,-5.5}, {-5,-5},{0,0}};
    }

    @DataProvider(name = "numbers_toMultiply")
    public Object[][] provideCorrectNumbers_toMultiply(){
        return new Object [][] {{2.8, 5}, {2, 7}, {5, 2.8},{2.5, 5.6}};
    }

    @DataProvider(name = "numbers_toDivide")
    public Object[][] provideCorrectNumbers_toDivide(){
        return new Object [][] {{9, 3}, {27, 9}, {7.5, 2.5}};
    }
}
