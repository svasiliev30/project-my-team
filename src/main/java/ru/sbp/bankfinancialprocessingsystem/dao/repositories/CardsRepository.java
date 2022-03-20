package ru.sbp.bankfinancialprocessingsystem.dao.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;

/**
 * Интерфейс CardsRepository для реализации методов JpaRepository
 *
 * @version 1.0
 * @autor Evgeniy Nochkin
 * @see Card#Object()
 */
@Repository
public interface CardsRepository extends JpaRepository<Card, Integer> {

    Card findByNumberAccount(Account account);
}
