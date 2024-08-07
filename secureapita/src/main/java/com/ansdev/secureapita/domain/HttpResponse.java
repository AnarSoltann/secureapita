package com.ansdev.secureapita.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
    protected String timeStamp;
    protected int httpStatusCode;
    protected String httpStatus;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;
}
