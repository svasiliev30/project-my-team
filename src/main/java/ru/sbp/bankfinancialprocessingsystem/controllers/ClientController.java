package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.CardsRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Обработка запроса информации по клиенту
 *
 * @author Evgeniy Nochkin
 * @version 1.0
 */
@Controller
public class ClientController {

    @Autowired
    ClientsRepository clientsRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CardsRepository cardsRepository;

    /**
     * Формирование информации по логину клиента
     * @param userLogin логин клиента
     * @return список счетов и карт
     */
    @GetMapping("/clientinfo/{userLogin}")
    public ModelAndView getClientInfo(@PathVariable(value = "userLogin") String userLogin) {
        ModelAndView mav = new ModelAndView();

        Clients client = clientsRepository.findByUserLogin(userLogin);
        List<Account> accounts = accountRepository.findByUserLogin(userLogin);
        Map<Account, Card> cards = new HashMap<>();

        if (accounts.size() > 0) {
            for (Account acc : accounts) {
                Card card = acc.getCard();
                cards.put(acc, card);
            }
        }

        mav.setViewName("clientinfo.jsp");
        mav.addObject("client", client);
        mav.addObject("accounts", cards);

        return mav;
    }
}
