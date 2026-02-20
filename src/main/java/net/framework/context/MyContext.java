package net.framework.context;

import net.framework.annotations.MyAutowired;
import net.framework.annotations.MyComponent;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MyContext {

    private Map<Class<?>, Object> instances = new HashMap<>();


    public MyContext(String[] packages) {
        try {

            for (String pack : packages) {
                scanAndInstantiate(pack);
            }

            injectDependencies();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void scanAndInstantiate(String packageName) throws Exception {
        String path = packageName.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(path);

        if (resource != null) {
            File directory = new File(resource.getFile());
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".class")) {
                        String className = packageName + "." + file.getName().replace(".class", "");
                        Class<?> cls = Class.forName(className);

                        // Wach l-classe fiha l-annotation @MyComponent ?
                        if (cls.isAnnotationPresent(MyComponent.class)) {
                            // Creation dyal l-objet b l-Reflection API
                            Object instance = cls.getDeclaredConstructor().newInstance();

                            // N-stockew l-objet f l-Map b s-smiya dyal l-interface dyalu (ex: IDao)
                            Class<?>[] interfaces = cls.getInterfaces();
                            if (interfaces.length > 0) {
                                instances.put(interfaces[0], instance);
                            } else {
                                instances.put(cls, instance);
                            }
                        }
                    }
                }
            }
        }
    }


    private void injectDependencies() throws Exception {

        for (Object obj : instances.values()) {

            for (Field field : obj.getClass().getDeclaredFields()) {


                if (field.isAnnotationPresent(MyAutowired.class)) {
                    field.setAccessible(true);

                    Object dependency = instances.get(field.getType());

                    if (dependency != null) {
                        field.set(obj, dependency);
                    }
                }
            }
        }
    }


    public <T> T getBean(Class<T> type) {
        return (T) instances.get(type);
    }
}