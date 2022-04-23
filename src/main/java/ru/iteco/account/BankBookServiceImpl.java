package ru.iteco.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.iteco.account.exception.BankBookWithCurrencyAlreadyHaveException;
import ru.iteco.account.exception.NotFoundException;
import ru.iteco.account.exception.NumberCannotBeModifiedException;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BankBookServiceImpl implements BankBookService {
    private final Map<Integer, BankBookDto> bankBookDtoMap = new ConcurrentHashMap<>();
    private final AtomicInteger sequenceId = new AtomicInteger(1);

    @PostConstruct
    void init() {
        bankBookDtoMap.put(1, BankBookDto.builder().id(1).userId(1).number("number1").amount(BigDecimal.TEN).currency("RUB").build());
    }

    @Override
    public BankBookDto findById(Integer id) {
        BankBookDto bankBookDto = bankBookDtoMap.get(id);
        if (bankBookDto == null) {
            throw new NotFoundException("Account not found");
        }
        return bankBookDto;
    }

    @Override
    public List<BankBookDto> findByUserId(Integer userId) {
        List<BankBookDto> bankBookDtos = bankBookDtoMap.values().stream()
                .filter(bankBookDto -> userId.equals(bankBookDto.getUserId()))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(bankBookDtos)) {
            throw new NotFoundException("User don`t have accounts");
        }
        return bankBookDtos;
    }

    @Override
    public BankBookDto create(BankBookDto bankBookDto) {
        boolean hasBankBook = bankBookDtoMap.values().stream().anyMatch(bankBook -> bankBook.getUserId().equals(bankBookDto.getUserId())
                && bankBook.getNumber().equals(bankBookDto.getNumber()) && bankBook.getCurrency().equals(bankBookDto.getCurrency()));
        if (hasBankBook) {
            throw new BankBookWithCurrencyAlreadyHaveException("Account with currency still exist");
        }
        int id = sequenceId.getAndIncrement();
        bankBookDto.setId(id);
        bankBookDtoMap.put(id, bankBookDto);
        return bankBookDto;
    }

    @Override
    public BankBookDto update(BankBookDto bankBookDto) {
        BankBookDto bankBookDtoFromMap = bankBookDtoMap.get(bankBookDto.getId());
        if (bankBookDtoFromMap == null) {
            throw new NotFoundException("Account not found");
        }
        if (!bankBookDtoFromMap.getNumber().equals(bankBookDto.getNumber())) {
            throw new NumberCannotBeModifiedException("Number could not be modified");
        }
        bankBookDtoMap.put(bankBookDto.getId(), bankBookDto);
        return bankBookDto;
    }

    @Override
    public void delete(Integer id) {
        bankBookDtoMap.remove(id);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        List<Integer> bankBookRemoveId = bankBookDtoMap.values().stream().filter(bankBookDto -> bankBookDto.getUserId().equals(userId))
                .map(BankBookDto::getId)
                .collect(Collectors.toList());
        for (Integer removeId : bankBookRemoveId) {
            bankBookDtoMap.remove(removeId);
        }
    }
}
