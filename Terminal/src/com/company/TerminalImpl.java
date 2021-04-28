package com.company;

public class TerminalImpl implements Terminal {
    private final TerminalServer server = TerminalServer.getInstance();
    private final PinValidator pinValidator = new PinValidator();
    private UserAccount account;

    public TerminalImpl(long ID) {
        account = pinValidator.logIn(ID);
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }

    @Override
    public void putMoney(long money) throws IllegalArgumentException {
        try {
            if (money % 100 != 0)
                throw new IllegalArgumentException("Внесённая сумма должна быть кратна 100");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        account.putMoney(money);
    }

    @Override
    public void getMoney(long money) throws IllegalArgumentException {
        try {
            if (money % 100 != 0)
                throw new IllegalArgumentException("Сумма должна быть кратна 100");

            if (money > getBalance())
                throw new IllegalArgumentException("Сумма не должна превышать баланс");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        account.getMoney(money);
    }
}