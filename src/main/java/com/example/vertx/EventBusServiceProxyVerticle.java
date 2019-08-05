package com.example.vertx;

import com.example.vertx.service.GreetingService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ServiceBinder;
import lombok.extern.log4j.Log4j2;

/**
 * @author wuxii
 */
@Log4j2
public class EventBusServiceProxyVerticle extends AbstractVerticle {

    private static final String address = "service-proxy-address";

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(EventBusServiceProxyVerticle.class.getName());
    }

    private GreetingService greetingService;

    @Override
    public void start() {
        new ServiceBinder(vertx)
                .setAddress(address)
                .register(GreetingService.class, (name, handler) -> handler.handle(Future.succeededFuture("Hello " + name)));

        this.greetingService = GreetingService.createProxy(vertx, address);

        vertx.setPeriodic(5000,
                ar -> greetingService.greeting("foo", msg -> log.info("service say greeting: {}", msg.result())));
    }

}
