package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.springframework.stereotype.Component;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.AccountType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;

import javax.persistence.*;

/**
 * @version 2.0
 * @autor Sergey Vasiliev
 */
@Component
@Entity
public class Account {

    /**
     * Генерация уникального айди счета
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Id")
    private  Integer id;

    /**
     *Номер счета
     */
    @Column(name = "number_account")
    private String numberAccount;

    /**
     * Логин пользователя
     */
    @Column(name = "user_login")
    private String userLogin;

    /**
     * Активный ли аккаунт
     */
    @Column(name = "account_active")
    private Boolean accountActive;

    /**
     * Дата открытия
     */
    @Column(name = "date_open")
    private java.sql.Date dateOpen;

    /**
     * Тип валюты
     */
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    /**
     * Количество валюты в рублях
     */
    @Column(name = "balance")
    private Double balance;

    /**
     * Тип аккаунта
     */
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)

    private AccountType accountType;

    /**
     * Дата закрытия
     */
    @Column(name = "date_close")

    private java.sql.Date dateClose;

    /**
     * Связанный ийди карты.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private Card card;

    /**
     * Конструктор класса
     */
    public Account() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String numberAccount номер счета 20 знаков
     * @param - String userLogin логин пользователя
     * @param - Boolean accountActive признак отсутствия ограничений по счету
     * @param - java.sql.Date dateOpen дата открытия
     * @param - CurrencyType currency валюта счета
     * @param - Double balance исходящий остаток
     * @param - AccountType accountType тип счета
     * @param - java.sql.Date dateClose дата закрытия счета
     */
    public Account(String numberAccount, String userLogin, Boolean accountActive, java.sql.Date dateOpen, CurrencyType currency, Double balance, AccountType accountType, java.sql.Date dateClose) {
        this.numberAccount = numberAccount;
        this.userLogin = userLogin;
        this.accountActive = accountActive;
        this.dateOpen = dateOpen;
        this.currency = currency;
        this.balance = balance;
        this.accountType = accountType;
        this.dateClose = dateClose;
    }

    /**
     * Отправляем номер счета
     * @return
     */
    public String getNumberAccount() {
        return numberAccount;
    }

    /**
     * Присваиваем номер счета
     * @param numberAccount
     */
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    /**
     * Отправляем логин.
     * @return
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * присваиваем Логин
     * @param userLogin
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * Отправляем активный ли аккаунт.
     * @return
     */
    public Boolean getAccountActive() {
        return accountActive;
    }

    /**
     * Присваиваем активность
     * @param accountActive
     */
    public void setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
    }

    /**
     * Отправляем дату открытия.
     * @return
     */
    public java.sql.Date getDateOpen() {
        return dateOpen;
    }

    /**
     * Присваиваем дату открытия
     * @param dateOpen
     */
    public void setDateOpen(java.sql.Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    /**
     * отправляем тип валюты
     * @return
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * присваиваем тип валюты
     * @param currency
     */
    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    /**
     * Отсылает баланс счета
     * @return
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Присваиваем баланм счета
     * @param balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * Высылаем тип аккаунта
     * @return
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Присваиваем тип аккаунта
     * @param accountType
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Высылаем дату закрытия
     * @return
     */
    public java.sql.Date getDateClose() {
        return dateClose;
    }

    /**
     * Приравниваем дату закрытия
     * @param dateClose
     */
    public void setDateClose(java.sql.Date dateClose) {
        this.dateClose = dateClose;
    }

    /**
     * Вызываем id карты
     * @return
     */
    public Card getCard() {
        return card;
    }

    /**
     * Вызываем id карты
     * @return
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * Сравниваем данные аккаунта с помощью equals, если они равны то вернется true ,если нет то false.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (numberAccount != null ? !numberAccount.equals(account.numberAccount) : account.numberAccount != null)
            return false;
        if (userLogin != null ? !userLogin.equals(account.userLogin) : account.userLogin != null) return false;
        if (accountActive != null ? !accountActive.equals(account.accountActive) : account.accountActive != null)
            return false;
        if (dateOpen != null ? !dateOpen.equals(account.dateOpen) : account.dateOpen != null) return false;
        if (currency != null ? !currency.equals(account.currency) : account.currency != null) return false;
        if (balance != 0 ? !balance.equals(account.balance) : account.balance != null) return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null)
            return false;
        if (dateClose != null ? !dateClose.equals(account.dateClose) : account.dateClose != null) return false;

        return true;
    }

    /**
     * Сравниваем данные аккаунта с помощью hashCode, если они равны то вернется true ,если нет то false.
     * @return
     */
    @Override
    public int hashCode() {
        int result = numberAccount != null ? numberAccount.hashCode() : 0;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (accountActive != null ? accountActive.hashCode() : 0);
        result = 31 * result + (dateOpen != null ? dateOpen.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        return result;
    }

    /**
     * Выводит всю информацию по аккаунту
     * @return
     */
    @Override
    public String toString() {
        return "Accounts{" +
                "numberAccount='" + numberAccount + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", accountActive=" + accountActive +
                ", dateOpen=" + dateOpen +
                ", currency=" + currency +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", dateClose=" + dateClose +
                '}';
    }
}
