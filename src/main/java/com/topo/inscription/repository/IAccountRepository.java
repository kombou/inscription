package com.topo.inscription.repository;

import com.topo.inscription.entity.Account;

public interface IAccountRepository {
    void save(Account account);

    Account findById(int id);

    boolean useEmail(String email);

    boolean useTelephone(String tel);

    Account findByEmail(String email);
}
