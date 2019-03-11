package hu.me;

public interface Validator<T> {
    boolean validate(T input);
}
