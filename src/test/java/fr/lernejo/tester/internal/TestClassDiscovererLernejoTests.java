package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDiscovererLernejoTests {

    private static final String myTestPackage = "fr.lernejo.tester";

    @TestMethod
    public static void main(String[] args) {
        TestClassDiscoverer myTestClassDiscoverer = new TestClassDiscoverer( myTestPackage );
        List<TestClassDescription> myTestClassDescriptionList = myTestClassDiscoverer.listTestClasses();
        myTestClassDescriptionList.forEach( tcd -> {
            System.out.println("Found class: " + tcd.testClass.getName() );
        });
    }
}
