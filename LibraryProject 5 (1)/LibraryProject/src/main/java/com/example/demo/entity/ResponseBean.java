
package com.example.demo.entity;


public class ResponseBean<T> {

    private T data;
    private ResponseStatus status;
    private String code;
    private String message;

    public enum ResponseStatus {
        SUCCESS, FAILURE, PER_FAIL
    }

    public ResponseBean() {
    }

    public ResponseBean(T data) {
        this.data = data;
    }

    public static <T> ResponseBean<T> of(T data) {
        ResponseBean<T> rb = new ResponseBean<>(data);
        rb.setStatus(ResponseStatus.SUCCESS);
        return rb;
    }

    public static <T> ResponseBean<T> error(String code, String message) {
        ResponseBean<T> rb = new ResponseBean<>();
        rb.setStatus(ResponseStatus.FAILURE);
        rb.setCode(code);
        rb.setMessage(message);
        return rb;
    }

    public boolean isFailed() {
        return ResponseStatus.FAILURE.equals(this.status);
    }

    public boolean isSuccess() {
        return ResponseStatus.SUCCESS.equals(this.status);
    }

    public boolean isPartialFail() {
        return ResponseStatus.PER_FAIL.equals(this.status);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseBean<Response> orElseThrow() {
        if (data == null) {
            throw new IllegalStateException("Response data is null");
        }
        return null;
    }

    public static ResponseBean<Response> success(Response response) {
        ResponseBean<Response> rb = new ResponseBean<>();
        rb.setStatus(ResponseStatus.SUCCESS);
        rb.setData(response);
        return rb;
    }

    public Object thenReturn(ResponseBean<Response> successResponse) {
        return successResponse;
    }

	

}
