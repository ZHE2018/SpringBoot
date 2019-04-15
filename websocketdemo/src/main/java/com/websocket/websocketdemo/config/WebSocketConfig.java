package com.websocket.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");// 代理消息的前缀 该前缀的消息会转发给代理(broker),由
        //代理转发客户端
        registry.setApplicationDestinationPrefixes("/app");
        //配置可以被@MessageMapping 注解的方法处理的消息前缀
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //开启一个前缀为"/chat"的endPoint,并开启sockjs支持 sockjs用于解决websocket 对于浏览器的兼容
        registry.addEndpoint("/chat").withSockJS();
    }
}
