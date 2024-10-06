package com.example.demo.http.response;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public abstract class Response {
    private final HttpExchange exchange;
    private final int status;

    Response(HttpExchange exchange, int status) {
        this.exchange = exchange;
        this.status = status;
    }

    public void send(String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(this.status, bytes.length);
        exchange.getResponseBody().write(bytes);
    }
}
