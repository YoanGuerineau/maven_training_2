package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.*;

public class TestClassDiscoverer {

    private String packageName;

    public TestClassDiscoverer(String packageName) {
        this.packageName = packageName;
    }

    public List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections( packageName, new SubTypesScanner(false));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        Set<Class<?>> foundClasses = new HashSet<>();
        allClasses.forEach(
            c -> {
                if ( c.getName().endsWith("LernejoTests") ) {
                    Method[] classMethods = c.getMethods();
                    Arrays.stream(classMethods).forEach(
                        m -> {
                            if (m.isAnnotationPresent(TestMethod.class)) {
                                foundClasses.add(c);
                            }
                        }
                    );
                }
            }
        );
        return foundClasses.stream().map(TestClassDescription::new).toList();
    }
}
