package com.may.com.may.Exception;

/**
 * Created by mayxys on 2016/7/15.
 */
public class BaseException extends Exception{
    private static final long serialVersionUID = 8027318302270429887L;
    private String exceptionCode="";
    private String exceptionMessage="";
    public BaseException(){
        super();
    }
    public BaseException(String exceptionMessage){
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public BaseException(String exceptionCode,String exceptionMessage){
        super(exceptionMessage);
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
