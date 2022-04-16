package ru.iteco.account.service;

import org.springframework.stereotype.Service;
import ru.iteco.account.model.AccountInfo;

@Service
public class AccountServiceMockImpl implements AccountService {
    @Override
    public AccountInfo getAccountInfoById(Integer id) {
        return new AccountInfo();
    }

    @Override
    public String getPersonalInfoClass(){
        return  null;
    }
}
