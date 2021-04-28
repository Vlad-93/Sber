package com.company;

public class Main {

    public static void main(String[] args) {
        // Регистрация
        final long ID = 123456789;
        byte[] pin = {1, 2, 3, 4};
        UserAccount account = new UserAccount(ID, pin);

        // Вход в аккаунт через терминал
        TerminalImpl terminal = new TerminalImpl(ID);

        // Пополнение счёта / снятие наличных, проверка баланса
        System.out.println(terminal.getBalance());      // 0
        terminal.getMoney(1_000);                       // недостаточно средств
        terminal.putMoney(44);                          // не примет банкомат
        terminal.putMoney(1_000);                       // ok
        System.out.println(terminal.getBalance());      // 1_000
        terminal.getMoney(177);                         // не выдаст банкомат
        terminal.getMoney(800);                         // ok
        System.out.println(terminal.getBalance());      // 200
    }

}
