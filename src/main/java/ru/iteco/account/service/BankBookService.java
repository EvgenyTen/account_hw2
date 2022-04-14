package ru.iteco.account.service;

import ru.iteco.account.model.BankBook;

import java.util.List;

public interface BankBookService {
    List<BankBook> getBankBooksById(Integer id);
}
