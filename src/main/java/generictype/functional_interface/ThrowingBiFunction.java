package generictype.functional_interface;

@FunctionalInterface
interface ThrowingBiFunction<T, N, R, E extends Exception> {
    R apply(T t, N n) throws E;

}