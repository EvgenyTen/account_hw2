package ru.iteco.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/bank-book")
public class BankBookController {
    private final BankBookServiceImpl bankBookService;

    public BankBookController(BankBookServiceImpl bankBookService) {
        this.bankBookService = bankBookService;
    }

    @GetMapping({"/", "/{id}"})
    public ResponseEntity<BankBookDto> getBankBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(bankBookService.findById(id));
    }

    @GetMapping("/byUserId/{userid}")
    public ResponseEntity<List<BankBookDto>> getBankBookByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(bankBookService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<BankBookDto> createBankBook(@RequestBody BankBookDto bankBookDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bankBookService.create(bankBookDto));
    }

    @PutMapping
    public BankBookDto updateBankBook(@RequestBody BankBookDto bankBookDto) {
        return bankBookService.update(bankBookDto);
    }

    @DeleteMapping({"/", "/{id}"})
    public void deleteBankBook(@PathVariable Integer id) {
        bankBookService.delete(id);
    }

    @DeleteMapping({"/byUserId", "/byUserId/{id}"})
    public void deleteBankBookByUserId(@PathVariable Integer id) {
        bankBookService.deleteByUserId(id);
    }
}
