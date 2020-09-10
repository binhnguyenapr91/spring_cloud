package me.toam.springcloud.eurekaclient.common;

public interface CommonTransformer <E,M> {
    M toModel (E entity);
    E toEntity (M model);
}
