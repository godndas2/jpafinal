package org.jpa.study.exception;

// System.out.println("에러 메시지 : " + e.getMessage()); e.printStackTrace();
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String msg, Throwable t) {
        super(msg,t);
    }
    public ItemNotFoundException(String msg) {
        super(msg);
    }
    public ItemNotFoundException() {
        super();
    }

}
