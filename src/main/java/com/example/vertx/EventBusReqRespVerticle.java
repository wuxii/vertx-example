package com.example.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import lombok.extern.log4j.Log4j2;

/**
 * @author wuxii
 */
@Log4j2
public class EventBusReqRespVerticle extends AbstractVerticle {

    private static final String address = "req-resp-address";

    public static void main(String[] args) {
        // DeploymentOptions deploymentOptions = new DeploymentOptions().setWorker(true).setInstances(100);
        Vertx.vertx().deployVerticle(EventBusReqRespVerticle.class.getName(), new DeploymentOptions());
        // Vertx.clusteredVertx(new VertxOptions(), ar -> ar.result().deployVerticle(EventBusReqRespVerticle.class.getName()));
    }

    @Override
    public void start() throws Exception {
        EventBus eventBus = vertx.eventBus();

        eventBus.consumer(address, msg -> {
            log.info("receive message: {}", msg.body());
            msg.reply("pong!");
            // msg.reply("pong2!"); // no effect
        });

        vertx.setPeriodic(5000, e ->
                eventBus.request(address, "ping!", msg ->
                        log.info("reply message: {}", msg.result().body())));
    }

}
