package com.zonta.common.integration.gateways;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * Created by dimer on 16.02.18.
 */

@MessagingGateway(defaultRequestChannel = "zx.commonMessaging")
public interface CommonMessageGateway {
    void send(@Header("routingKey") String routingKey, @Payload Object payload, @Headers Map<String, Object> headers);
}
