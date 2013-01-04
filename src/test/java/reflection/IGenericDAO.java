package reflection;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public interface IGenericDAO<T>
{

    T find(Object id);

    void save(T entity);

    void remove(T entity);
}
