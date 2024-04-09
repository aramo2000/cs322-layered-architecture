package am.cs322;

import am.cs322.model.BankDTO;
import am.cs322.model.User;

public interface BankService {

    public BankDTO createBank(String firstName, String lastName, double balance);
    public BankDTO credit(String firstName, String lastName, double amount);
    public BankDTO debit(String firstName, String lastName, double amount);

}
