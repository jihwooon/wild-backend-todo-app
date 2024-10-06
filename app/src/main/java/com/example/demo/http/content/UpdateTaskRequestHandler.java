package com.example.demo.http.content;

import com.example.demo.controller.UpdateTaskResource;
import com.example.demo.http.RequestAttribute;
import com.example.demo.http.TaskPathId;
import java.io.IOException;

public class UpdateTaskRequestHandler implements RequestHandlerStrategy {

    private final UpdateTaskResource updateTaskResource = new UpdateTaskResource();
    private final TaskPathId taskPathId = new TaskPathId();

    @Override
    public boolean matches(RequestAttribute requestAttribute) {
        return requestAttribute.requestMethod().equals("PATCH")
                && requestAttribute.requestURI().startsWith("/tasks/");
    }

    @Override
    public String handle(RequestAttribute requestAttribute) throws IOException {
        Long taskId = taskPathId.getPathId(requestAttribute.requestURI());
        return updateTaskResource.handler(taskId,
                requestAttribute.requestContent());
    }
}
