package ru.sbp.bankfinancialprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.cardutil.CardUtil;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CardStatusType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.CardsRepository;

import java.sql.Date;
import java.util.List;

/**
 * Сервисы работы с банковскими картами
 *
 * @author Evgeniy Nochkin
 * @version 1.0
 */
@Service
public class CardService {

    @Autowired
    private CardsRepository repo;

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Создание карты
     * @param card карта с частично заполненными полями
     */
    public void createNewCard(Card card) {
        List<Card> list = repo.findAll();

        card.setExpirationDate(new Date(new java.util.Date().getTime()));
        card.setCardStatus(CardStatusType.Valid);
        card.setCardNumber(CardUtil.getNumberCard(list, card.getPaymentSystem()));

        repo.save(card);

        Account account = card.getNumberAccount();
        account.setCard(card);
        accountRepository.save(account);
    }
}
