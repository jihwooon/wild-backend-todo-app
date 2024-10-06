package com.example.demo;

import com.example.demo.http.RequestHandler;
import com.example.demo.http.ResponseContent;
import com.example.demo.http.ResponseHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class RequestResponseHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        RequestHandler requestHandler = new RequestHandler(exchange);

        String responseContent = getResponseContent(requestHandler);

        new ResponseHandler(exchange).send(responseContent);

    }

    private String getResponseContent(RequestHandler requestHandler)
            throws IOException {
        String requestContent = requestHandler.getRequestContent();
        String requestMethod = requestHandler.getRequestMethod();
        String requestURI = requestHandler.getRequestURI();

        String responseContent = new ResponseContent().getResponseContent(
                requestMethod, requestURI, requestContent);
        return responseContent;
    }
}
