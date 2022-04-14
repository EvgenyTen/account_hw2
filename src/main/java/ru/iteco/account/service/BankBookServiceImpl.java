package ru.iteco.account.service;

import lombok.Value;
import org.springframework.stereotype.Service;
import ru.iteco.account.model.BankBook;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankBookServiceImpl implements BankBookService {
    @Override
    public List<BankBook> getBankBooksById(Integer id) {
        BankBook bankBook = new BankBook();
        bankBook.setNumber(1L);
        bankBook.setUserId(id);
        ArrayList<BankBook> bankBooks = new ArrayList<BankBook>();
        bankBooks.add(bankBook);
        return bankBooks;
    }
}
