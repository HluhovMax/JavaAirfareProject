package airfare.mvc.dao;

/**
 * Created by Max Hluhov on 16.11.2018.
 */
public interface Repository<T> {
    void save(T t);
}
