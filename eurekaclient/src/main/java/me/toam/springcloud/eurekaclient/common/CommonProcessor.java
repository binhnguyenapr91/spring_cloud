package me.toam.springcloud.eurekaclient.common;

public abstract class CommonProcessor <ES,ET>{
    protected final ES service;

    protected final ET transformer;

    public CommonProcessor(ES service, ET transformer) {
        this.service = service;
        this.transformer = transformer;
    }
}
