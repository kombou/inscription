package com.topo.inscription.entity;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository instance = new Repository();
    private List<Account> data = new ArrayList<>();
    private int idCount = 0;

    private Repository() { }

    public static Repository getInstance() {
        return instance;
    }

    public int save(Account account){
        account.setId(idCount);
        data.add(account);
        idCount++;
        return idCount;
    }
    public Account findById(int id){
        return data.stream()
                .filter(account -> (new Integer(account.getId())).equals(id))
                .findFirst()
                .orElse(null);
    }
public boolean useEmail(String email){
        Account account = data.stream()
                .filter(account1 -> account1.getEmail().equals(email))
                .findFirst()
                .get();
        if(account==null)return false;
        return true;
}
    public boolean useTelephone(String tel){
        Account account = data.stream()
                .filter(account1 -> account1.getTelephone().equals(tel))
                .findFirst()
                .get();
        if(account==null)return false;
        return true;
    }
}
