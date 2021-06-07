package com.wiley.assessment.main.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBody {
    private int code;
    private HttpStatus status;
    private Object body;

    public ResponseBody() {
        this.code = HttpStatus.OK.value();
        this.status = HttpStatus.OK;
    }
}
