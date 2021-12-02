package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {

    @TestMethod
    public static void testSomeLernejoTestsClassDescription() {
        TestClassDescription myTestClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> myTestMethodList = myTestClassDescription.listTestMethods();
        myTestMethodList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        testSomeLernejoTestsClassDescription();
    }

}
