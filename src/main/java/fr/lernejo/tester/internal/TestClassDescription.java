package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class TestClassDescription {

    Class<?> testClass;

    public TestClassDescription( Class<?> targetClass ) {
        testClass = targetClass;
    }

    public List<Method> listTestMethods() {
        return Arrays.stream(this.testClass.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers()) && m.getReturnType().getName().equals("void") && m.getParameterCount() <= 0 && m.isAnnotationPresent(TestMethod.class)).toList();
    }
}
