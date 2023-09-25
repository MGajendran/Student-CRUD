package com.assessment.student.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Data
@NoArgsConstructor
public class GenericResponse {
    private boolean success = false;
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> data;

    public GenericResponse(boolean success, String errorCode, String errorMessage) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void add(String key, Object obj) {
        if (data == null)
            data = new HashMap<>();
        data.put(key, obj);
    }
}
