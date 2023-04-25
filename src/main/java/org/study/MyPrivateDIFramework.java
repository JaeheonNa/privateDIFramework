package org.study;

import java.lang.reflect.InvocationTargetException;

public class MyPrivateDIFramework {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WriterService writerService = ContainerService.getObject(WriterService.class);
        writerService.askPublish("나의 해방일지");
        writerService.askPublish("해리포터");
    }
}