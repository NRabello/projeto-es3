package com.nrabello.back.service;

import java.util.List;

public interface IFacade<T>{
    List<T> findAll();

}
