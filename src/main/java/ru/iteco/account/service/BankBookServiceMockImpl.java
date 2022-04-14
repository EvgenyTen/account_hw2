package ru.iteco.account.service;

import org.springframework.stereotype.Service;
import ru.iteco.account.model.BankBook;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankBookServiceMockImpl implements BankBookService {
    @Override
    public List<BankBook> getBankBooksById(Integer id) {
        return new ArrayList<BankBook>();
    }
}
