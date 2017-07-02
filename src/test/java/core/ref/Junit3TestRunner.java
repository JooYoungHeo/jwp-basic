package core.ref;

import org.junit.Test;

import java.lang.reflect.Method;

public class Junit3TestRunner {
    @Test
    public void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;
        Method[] methods = clazz.getDeclaredMethods();
        String str = "test";

        for (Method method : methods){
            String methodName = method.getName();
            if(methodName.startsWith(str)){
                method.invoke(clazz.newInstance());
            }
        }
    }
}
