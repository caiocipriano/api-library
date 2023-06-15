package com.dev.library.service.exeptions;

public class BusinessRuleException extends Exception {

	private static final long serialVersionUID = 1L;

    public BusinessRuleException(String msg) {
        super(msg);
    }

    public BusinessRuleException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
