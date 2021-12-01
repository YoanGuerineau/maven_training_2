package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {
    private static final TestClassDescription myTestClassDescription = new TestClassDescription(SomeLernejoTests.class);

    public static void main(String[] args) {
        List<Method> myTestMethodList = myTestClassDescription.listTestMethods();
        myTestMethodList.forEach(System.out::println);
    }

}
