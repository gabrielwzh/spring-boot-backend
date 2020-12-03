package com.springbootbackend.model;

public class ResponseModel {

    private String token;

    public ResponseModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "token='" + token + '\'' +
                '}';
    }

        public ResponseModel withToken(String token) {
        this.token = token;
        return this;
    }


    //    private String message;
//    private Object response;
//    private boolean success;
//
//    public ResponseModel(String message, Object response, boolean success) {
//        this.message = message;
//        this.response = response;
//        this.success = success;
//    }
//
//    public ResponseModel() {
//
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Object getResponse() {
//        return response;
//    }
//
//    public void setResponse(Object response) {
//        this.response = response;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    @Override
//    public String toString() {
//        return "ResponseModel{" +
//                "message='" + message + '\'' +
//                ", response=" + response +
//                ", success=" + success +
//                '}';
//    }
//
//    public ResponseModel withMessage(String message) {
//        this.message = message;
//        return this;
//    }
//
//    public ResponseModel withResponse(Object response) {
//        this.response = response;
//        return this;
//    }
//
//    public ResponseModel withSuccess(boolean success) {
//        this.success = success;
//        return this;
//    }
}
