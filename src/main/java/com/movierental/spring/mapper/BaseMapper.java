package com.movierental.spring.mapper;

public abstract class BaseMapper<T, K> {

    public abstract T toDto(K entity);
    public abstract K toEntity(T dto);
}
