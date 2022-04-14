package ru.iteco.account.service;

import ru.iteco.account.model.AccountInfo;

public interface AccountService {
    AccountInfo getAccountInfoById(Integer id);
}
