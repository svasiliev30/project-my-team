package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;

import java.util.List;

/**
 * Интерфейс AccountsRepository выполняет роль по поиску данных в таблице
 * и записи новых данных
 * @autor Sergey Vasiliev
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findById (Integer id);

    List<Account> findByUserLogin (String userLogin);

    Account findByNumberAccount (String numberAccount);

}
