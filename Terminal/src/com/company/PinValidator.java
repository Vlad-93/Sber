package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PinValidator {
    private final long TIME_BlOCK = 10_000;
    private long time = 0;

    public PinValidator() {}

    public UserAccount logIn(long ID) {
        byte[] pin = pinInput();
        int count = 0;

        UserAccount account = TerminalServer.getInstance().getAccount(ID);

        while (!Arrays.equals(account.getPin(), pin)) {
            System.out.println("Неправильный pin!");

            if (++count == 3)
                time = System.currentTimeMillis();

            count %= 3;
            pin = pinInput();

        }

        return account;
    }

    private byte[] pinInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        byte[] pin = new byte[4];

        System.out.println("Введите пин (4 цифры)");

        for (int i = 0; i < 4; ) {
            try {
                String input = bufferedReader.readLine();

                if (input.length() != 1)
                    throw new NumberFormatException();

                pin[i] = Byte.parseByte(input);

                long currentTime = System.currentTimeMillis();

                if (currentTime < time + TIME_BlOCK)
                    throw new AccountIsLockedException("Времени до снятия блокировки: " +
                            (time + TIME_BlOCK - currentTime) / 1_000 + 'c');

                i++;
            } catch (NumberFormatException e) {
                System.out.println("Введите цифру!");
            } catch (AccountIsLockedException e) {
                System.out.println(e.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return pin;
    }
}
