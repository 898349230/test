package java8.lambda3;

/**
 * 自定义三个参数的方法
 *
 * @param <T>
 * @param <U>
 * @param <V>
 * @param <R>
 * @author
 */
public interface TriFunction<T, U, V, R> {
    R Apply(T t, U u, V v);
}
