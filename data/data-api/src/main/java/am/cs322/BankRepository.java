package am.cs322;

import am.cs322.model.Bank;
import org.springframework.data.repository.CrudRepository;


public interface BankRepository extends CrudRepository<Bank, Long> {
}

