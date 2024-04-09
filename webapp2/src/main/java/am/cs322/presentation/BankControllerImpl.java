package am.cs322.presentation;

import am.cs322.BankService;
import am.cs322.model.BankDTO;
import am.cs322.presentation.model.CreateBankAccountRequest;
import am.cs322.presentation.model.TransactionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bank-account")
public class BankControllerImpl implements BankController {

    private final BankService bankService;

    public BankControllerImpl(BankService bankService) {
        this.bankService = bankService;
    }


    @Override
    @PostMapping
    public BankDTO createBank(@RequestBody CreateBankAccountRequest request) {
        return bankService.createBank(request.firstName(), request.lastName(), request.balance());
    }

    @Override
    @PostMapping("/credit")
    public BankDTO credit(@RequestBody TransactionRequest request) {
        return bankService.credit(request.firstName(), request.lastName(), request.amount());
    }

    @Override
    @PostMapping("/debit")
    public BankDTO debit(@RequestBody TransactionRequest request) {
        return bankService.debit(request.firstName(), request.lastName(), request.amount());
    }
}
