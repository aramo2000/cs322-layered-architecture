package am.cs322;

import am.cs322.model.CreateBankAccountRequest;
import am.cs322.model.TransactionRequest;
import am.cs322.model.BankDTO;

public interface BankController {

    public BankDTO createBank(CreateBankAccountRequest request);
    public BankDTO credit(TransactionRequest request);
    public BankDTO debit(TransactionRequest request);

}
