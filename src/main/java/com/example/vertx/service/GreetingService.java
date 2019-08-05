package com.example.vertx.service;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

@ProxyGen
public interface GreetingService {

    static GreetingService createProxy(Vertx vertx, String address) {
        return new GreetingServiceVertxEBProxy(vertx, address);
    }

    // return type must void or @Fluent
    void greeting(String name, Handler<AsyncResult<String>> handler);

}

