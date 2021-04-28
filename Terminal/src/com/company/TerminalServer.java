package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TerminalServer {
    private ArrayList<UserAccount> accounts = new ArrayList<>();
    private static TerminalServer terminalServer;

    public void addAccount(UserAccount account) {
        accounts.add(account);
    }

    public UserAccount getAccount(long ID) throws NoSuchElementException{
        for (UserAccount account : accounts)
            if (account.getID() == ID)
                return account;

        throw new NoSuchElementException("Аккаунта не существует");
    }

    public boolean IdIsFree(long ID) {
        for (UserAccount account : accounts)
            if (account.getID() == ID)
                return false;

        return true;
    }

    private TerminalServer() {}

    public static TerminalServer getInstance() {
        if (terminalServer == null)
            terminalServer = new TerminalServer();

        return terminalServer;
    }

}
