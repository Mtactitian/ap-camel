package com.alexb.apcamel.routes;

import com.alexb.apcamel.processor.MessageProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MessageRouter extends RouteBuilder {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void configure() throws Exception {
        from("scheduler:msgScheduler?concurrentTasks=3&delay=10s&useFixedDelay=true")
                .transform()
                .body(() ->String.valueOf(atomicInteger.incrementAndGet()))
                .to("rest:post:submit?host=localhost:8080")
                .setBody(atomicInteger::get)
                .process(new MessageProcessor())
                .to("log:com.alexb.MessageReceiver?level=INFO&showExchangePattern=false&showBodyType=false&");
    }
}
