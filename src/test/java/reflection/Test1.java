package reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.junit.Test;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public class Test1
{

    @Test
    public void test()
    {
        Class c = CustomerIDAO.class;
        Type[] ta = c.getGenericInterfaces();
        for (Type t : ta) {
            ParameterizedType pt = (ParameterizedType) t;
            System.out.println((Class) pt.getActualTypeArguments()[0]);
        }
    }
}
