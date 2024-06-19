package com.nrabello.back.strategies;

import java.util.List;

public interface IStrategy<T>{
    List<T> process(T t);
}
