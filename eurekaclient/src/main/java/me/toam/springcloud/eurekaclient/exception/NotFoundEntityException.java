package me.toam.springcloud.eurekaclient.exception;

import lombok.Getter;

import java.util.function.Supplier;

public class NotFoundEntityException extends Exception{
    private static final long serialVersionUID = -718639735490655218L;
    @Getter
    String error;
    public NotFoundEntityException(String error, String message) {
        super(message);
        this.error = error;
    }

    public static Supplier<NotFoundEntityException> ofSupplier(String message){
        return ofSupplier(null,message);
    }
    public static Supplier<NotFoundEntityException> ofSupplier(String error, String message){
        return () -> of(error,message);
    }

    public static NotFoundEntityException of(String message){
        return of(null,message);
    }
    public static NotFoundEntityException of(String error, String message){
            return new NotFoundEntityException(error,message);
}
}
