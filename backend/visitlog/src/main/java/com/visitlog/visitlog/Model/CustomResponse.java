package com.visitlog.visitlog.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
    private String response;
    private String message;
    private Object data;

    public CustomResponse(String response, String message, Object data) {
        this.response = response;
        this.message = message;
        this.data = data;
    }
}