package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.util.List;

public class TestClassDiscovererLernejoTests {

    @TestMethod
    public static void testSomeLernejoTestsClassDiscoverer() {
        String myTestPackage = "fr.lernejo.tester";
        TestClassDiscoverer myTestClassDiscoverer = new TestClassDiscoverer( myTestPackage );
        List<TestClassDescription> myTestClassDescriptionList = myTestClassDiscoverer.listTestClasses();
            myTestClassDescriptionList.forEach( tcd -> {
            System.out.println("Found class: " + tcd.getTestClass().getName() );
        });
    }

}
