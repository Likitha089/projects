package com.library.book.Entity;

public class ResponseBean<T> {
    private T data;
    private ResponseStatus status;
    private String code;
    private String message;

    public enum ResponseStatus {
        SUCCESS, FAILURE, PER_FAIL
    }
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
    public T getData() {
        return data;
    }
    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public ResponseBean() {
    }

    public ResponseBean(T data) {
        this.data = data;
    }

    public static <T> ResponseBean<T> error(String code, String message) {
        ResponseBean<T> rb = new ResponseBean<>();
        rb.setStatus(ResponseStatus.FAILURE);
        rb.setCode(code);
        rb.setMessage(message);
        return rb;
    }
    public static <T> ResponseBean<T> of(T data) {
        ResponseBean<T> rb = new ResponseBean<>(data);
        rb.setStatus(ResponseStatus.SUCCESS);
        return rb;
    }
    public boolean isSuccess() {
        return ResponseStatus.SUCCESS.equals(this.status);
    }
}
