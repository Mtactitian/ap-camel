package com.alexb.apcamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class MessageProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) {
        Message exchangeIn = exchange.getIn();
        String body = exchangeIn.getBody(String.class);

        exchangeIn.setBody("Msg #" + body);
    }
}
