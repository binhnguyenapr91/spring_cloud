package me.toam.springcloud.eurekaclient.common;

import me.toam.springcloud.eurekaclient.exception.NotFoundEntityException;

import java.util.Optional;
import java.util.function.Consumer;

public abstract class CommonService<E,ID,R extends CommonRepository<E,ID>>{

    protected final R repo;

    public CommonService(R repo) {
        this.repo = repo;
    }

    public Optional<E> getById(ID id){
        return repo.findById(id);
    }

    public E getOrElseThrow (ID id, String message) throws NotFoundEntityException {
        return this.getById(id).orElseThrow(NotFoundEntityException.ofSupplier("NOT FOUND"));
    }

    public E save(E entity){
        return repo.save(entity);
    }

    public E delete(E entity){
        repo.delete(entity);
        return entity;
    }

    public E update(E entity, Consumer<E> fieldConsumer){
        fieldConsumer.accept(entity);
        this.save(entity);
        return entity;
    }
}
