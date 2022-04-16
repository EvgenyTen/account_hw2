package ru.iteco.account.service;

import ru.iteco.account.model.annotation.EncryptResult;

public interface IObject {
    @EncryptResult
    String getInfo();
}
