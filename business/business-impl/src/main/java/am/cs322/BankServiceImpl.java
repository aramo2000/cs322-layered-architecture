package am.cs322;

import am.cs322.model.Bank;
import am.cs322.model.BankDTO;
import am.cs322.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final UserRepository userRepository;

    public BankServiceImpl(BankRepository bankRepository, UserRepository userRepository) {
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BankDTO createBank(String firstName, String lastName, double balance) {
        Optional<User> u = userRepository.findByFirstNameAndLastName(firstName, lastName);
        if(u.isEmpty()){
            throw new IllegalArgumentException("No User");
        }
        User user = u.get();
        Bank b = bankRepository.save(new Bank(user, balance));
        user.setBank(b);
        userRepository.save(user);
        return new BankDTO("Balance: "+ b.getBalance());
    }


    public BankDTO credit(String firstName, String lastName, double amount) {
        Optional<User> u = userRepository.findByFirstNameAndLastName(firstName, lastName);
        if(u.isPresent()){
            Bank b = u.get().getBank();
            if(b != null) {
                b.setBalance(b.getBalance() + amount);
                bankRepository.save(b);
                return new BankDTO("Balance:" + b.getBalance());
            }
        }else {
            throw new IllegalArgumentException("No Bank");
        }
        throw new IllegalArgumentException("No User");
    }


    public BankDTO debit(String firstName, String lastName, double amount) {
        Optional<User> u = userRepository.findByFirstNameAndLastName(firstName, lastName);
        if(u.isPresent()){
            Bank b = u.get().getBank();
            if (b!=null){
                if (b.getBalance() >= amount) {
                    b.setBalance(b.getBalance() - amount);
                    bankRepository.save(b);
                    return new BankDTO("Balance:"+ b.getBalance());
                } else {
                    throw new IllegalArgumentException("No Balance");
                }
            }else {
                throw new IllegalArgumentException("No Bank");
            }

        }else {
            throw new IllegalArgumentException("No User");
        }
    }

}