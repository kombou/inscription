package com.topo.inscription.repository;

import com.topo.inscription.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IAccountRepository {
    private static Repository instance = new Repository();
    private List<Account> data = new ArrayList<>();
    private int idCount = 0;

    private Repository() {
    }

    public static Repository getInstance() {
        return instance;
    }

    @Override
    public void save(Account account) {
        idCount++;
        account.setId(idCount);
        data.add(account);
    }

    @Override
    public Account findById(int id) {
        return data.stream()
                .filter(account -> (new Integer(account.getId())).equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean useEmail(String email) {
        Account account = data.stream()
                .filter(account1 -> account1.getEmail().equals(email))
                .findFirst().orElse(null);
        if (account == null) return false;
        return true;
    }

    @Override
    public boolean useTelephone(String tel) {
        Account account = data.stream()
                .filter(account1 -> account1.getTelephone().equals(tel))
                .findFirst()
                .orElse(null);
        if (account == null) return false;
        return true;
    }
    @Override
    public Account findByEmail(String email){
        return data.stream()
                .filter(account1 -> account1.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
