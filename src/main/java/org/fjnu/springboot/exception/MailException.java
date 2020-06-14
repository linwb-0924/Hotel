package org.fjnu.springboot.exception;

/**
 * @author wb_Lin
 * @create 2020-04-13 21:43
 */
public class MailException extends Exception {

    public MailException() {

        super("这是一个不合法的邮件地址");
    }
}
