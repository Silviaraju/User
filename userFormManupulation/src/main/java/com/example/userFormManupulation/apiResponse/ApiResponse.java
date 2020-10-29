package com.example.userFormManupulation.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<U> {
    private Integer status;
    private String message;
    private Object result;

    public ApiResponse(Integer status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
