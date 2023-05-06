package bank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import bank.domain.Account;

public interface AccountDAO extends JpaRepository<Account, Long> {

}
