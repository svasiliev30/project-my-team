package ru.sbp.bankfinancialprocessingsystem.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;

/**
 * Сервис для снятия и получения денег.
 * @autor Sergey Vasiliev
 */
@Service
public class СalculationsAccount {

    /**
     * Вызов entity для работы с db
     */
    @Autowired
    private Account entity;

    /**
     * Связь с репозеторием db
     */
    private AccountRepository repository;


    /**
     * Старая сумма из bd.
     */
    private double oldBalance;

    /**
     * Новая сумма.
     */
    private double newBalance;

    /**
     * Номер аккаунта.
     */
    private String numberAccount;

    /**
     * Пустой конструктор.
     */
    public СalculationsAccount(){}

    /**
     * Возвращает старый баланс.
     * @return
     */
    public double getOldBalance() {
        return oldBalance;
    }

    /**
     * Возвращает новый баланс.
     * @return
     */
    public double getNewBalance() {
        return newBalance;
    }

    /**
     * Присваиваем ентити аккаунта.
     * @param entity
     */
    @Autowired
    public void setEntity(Account entity) {
        this.entity = entity;
    }

    /**
     * Присваиваем репозиторий bd.
     * @param repository
     */
    @Autowired
    public void setRepository(AccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Присваивает новый баланс и номер аккаунта.
     * @param newBalance
     * @param numberAccount
     */
    public void setNewBalanceAndNumberAccount(double newBalance, String numberAccount) {
        this.newBalance = newBalance;
        this.numberAccount = numberAccount;
        entity = repository.findByNumberAccount(numberAccount);
    }

    /**
     * Суммирует стырый баланс с новой входимой суммой(которую вводит пользователь).
     */
    public void amountOfMoney (){

        oldBalance = entity.getBalance();
        double a = oldBalance + newBalance;
        double b = Math.round(a*10);
        newBalance =b/10;
    }

    /**
     * Вычетает из стырог баланса, новую входимую сумму(который вводит пользователь).
     */
    public void withdrawOfMoney(){
        oldBalance = entity.getBalance();
        double a = oldBalance - newBalance;
        double b = Math.round(a*10);
        newBalance =b/10;
    }
}
