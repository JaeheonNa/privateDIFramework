package org.study;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            Inject annotation = f.getAnnotation(Inject.class);
            if(annotation != null){
                try {
                    Object fieldInstance = createInstance(f.getType());
                    f.set(instance, fieldInstance);
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    public static <T> T createInstance(Class<T> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return classType.getConstructor().newInstance();
    }
}
