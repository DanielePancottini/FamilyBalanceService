package it.team4tech.familybalance.utils;

/**
 * Functional interface that consumes three args and return a value
 * 
 * @author Daniele Pancottini
 *
 * @param <T> input type
 * @param <U> input type
 * @param <V> input type
 * @param <R> return type
 */

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
	public R apply(T x, U y, V z);
}
