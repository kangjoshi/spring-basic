package com.example.springbasic.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
/*
* ScopedProxyMode
*   TARGET_CLASS : 클래스의 경우
*   INTERFACES : 인터페이스의 경우
*
*
* */
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class MyLogger {

    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] [" + requestUrl + "] [" + message + "]");
    }

    @PostConstruct
    public void init() {
       uuid = UUID.randomUUID().toString();
       System.out.println("[" + uuid + "] request scope bean created : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean closed : " + this);
    }

}
