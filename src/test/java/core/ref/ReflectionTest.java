package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;
import next.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            logger.debug("field name: {}", field.getName());
        }

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            logger.debug("constructor name: {}", constructor.getName());
        }

        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            logger.debug("method name: {}", method.getName());
        }
    }
    
    @Test
    public void newInstanceWithConstructorArgs() {
        Class<User> clazz = User.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            Class prevc[] = constructor.getParameterTypes();
            for(Class zxcv : prevc){
                System.out.println(zxcv);
            }
//            try {
//                User user = (User) constructor.newInstance("asdf", "asdf", "asdf", "asdf");
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
        }
    }
    
    @Test
    public void privateFieldAccess() {
        Class<Student> clazz = Student.class;
        Field nameField = null;
        try {
            nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            Student student = new Student();
            nameField.set(student, "가나다");
            System.out.println(student.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
