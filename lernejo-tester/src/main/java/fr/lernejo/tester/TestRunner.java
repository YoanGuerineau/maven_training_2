package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDescription;
import fr.lernejo.tester.internal.TestClassDiscoverer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestRunner {

    public static void main(String[] args) {
        for ( String arg : args ){
            TestClassDiscoverer myTestClassDiscoverer = new TestClassDiscoverer( arg );
            List<TestClassDescription> myTestClassDescriptionList = myTestClassDiscoverer.listTestClasses();
            myTestClassDescriptionList.forEach( tcd -> {
                System.out.println("Found class: " +  tcd.getTestClass().getName() );
                List<Method> classMethods = tcd.listTestMethods();
                Object testInstance = null;
                try {
                    testInstance = tcd.getTestClass().getConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                Object finalTestInstance = testInstance;
                AtomicInteger successCount = new AtomicInteger();
                AtomicInteger failCount = new AtomicInteger();
                long startClassTest = System.currentTimeMillis();
                classMethods.forEach(
                    method -> {
                        long start = System.currentTimeMillis();
                        System.out.print( method + " " );
                        try {
                            method.invoke( finalTestInstance );
                            System.out.print( "OK " );
                            successCount.getAndIncrement();
                        } catch (Exception e) {
                            System.out.print("KO ");
                            failCount.getAndIncrement();
                        }
                        long end = System.currentTimeMillis();
                        System.out.print( ( end - start ) + " ms " );
                        System.out.println();
                    }
                );
                long endClassTest = System.currentTimeMillis();
                System.out.println("Tests launched: " + (successCount.addAndGet(failCount.get())) + " | Tests failed: " + failCount.get() + " | Total tests duration: " + (endClassTest - startClassTest) + " ms");
            });
        }
    }
}
