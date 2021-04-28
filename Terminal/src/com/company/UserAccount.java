package com.company;

public class UserAccount {
    private final long ID;
    private byte[] pin;
    private double balance = 0;

    public UserAccount(long ID, byte[] pin) throws IllegalArgumentException {
        TerminalServer server = TerminalServer.getInstance();

        if (server.IdIsFree(ID)) {
            this.ID = ID;
            this.pin = pin;
            server.addAccount(this);
        } else
            throw new IllegalArgumentException("Аккаунт с указанным ID уже существует");
    }

    public double getBalance() {
        return balance;
    }

    public void putMoney(double money) {
        balance += money;
    }

    public void getMoney(double money) {
        balance -= money;
    }

    public long getID() {
        return ID;
    }

    public byte[] getPin() {
        return pin;
    }
}
