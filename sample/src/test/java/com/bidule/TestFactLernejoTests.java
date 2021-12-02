package com.bidule;

import fr.lernejo.tester.api.TestMethod;

public class TestFactLernejoTests {

    @TestMethod
    public void negative_value_should_throw_IllegalArgumentException() {
        int negativeValue = -1;
        Fact negativeFactTest = new Fact();
        negativeFactTest.fact(negativeValue);
    }

    @TestMethod
    public void factorial_5_should_equal_120() {
        int five = 5;
        Fact fiveFactTest = new Fact();
        fiveFactTest.fact(five);
    }
}
