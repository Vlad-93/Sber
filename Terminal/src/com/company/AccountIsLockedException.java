package com.company;

public class AccountIsLockedException extends Exception {

    public AccountIsLockedException() {}

    public AccountIsLockedException(String message) {
        super(message);
    }

}
