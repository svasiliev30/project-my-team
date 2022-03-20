package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.OperationType;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс Transactions - POJO-класс (Plain Old Java Object) таблицы accounts
 *
 * @version 2.0
 * @autor Sergey Vasiliev
 * @see
 *
 */
@Component
@Entity
public class Transactions {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    /**
     * Номер аккаунта
     */
    @Column(name = "number_account")
    @Fetch(FetchMode.SUBSELECT )
    private String numberAccount;

    /**
     * Дата транзакции
     */
    @Column(name = "date_transaction")
    private java.sql.Date dateTransaction;

    /**
     * Тип операции
     */
    @Column(name = "operation_type")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    /**
     * Сумма транзакций
     */
    @Column(name = "sum_transaction")
    private Double sumTransaction;

    /**
     * Тип валюты
     */
    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    /**
     * id терминала
     */
    @Column(name = "terminal_id")
    private String terminalId;

    /**
     * код авторизации
     */
    @Column(name = "code_authorization")
    private String codeAuthorization;

    /**
     * Конструктор класса
     */
    public Transactions() {

    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - int id
     * @param - String numberAccount
     * @param - java.sql.Date dateTransaction
     * @param - OperationType operationType
     * @param - Double sumTransaction
     * @param - CurrencyType currencyType
     * @param - String terminalId
     * @param - String codeAuthorization
     */
    public Transactions(int id, String numberAccount, java.sql.Date dateTransaction, OperationType operationType, Double sumTransaction, CurrencyType currencyType, String terminalId, String codeAuthorization) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.dateTransaction = dateTransaction;
        this.operationType = operationType;
        this.sumTransaction = sumTransaction;
        this.currencyType = currencyType;
        this.terminalId = terminalId;
        this.codeAuthorization = codeAuthorization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public java.sql.Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(java.sql.Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Double getSumTransaction() {
        return sumTransaction;
    }

    public void setSumTransaction(Double sumTransaction) {
        this.sumTransaction = sumTransaction;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getCodeAuthorization() {
        return codeAuthorization;
    }

    public void setCodeAuthorization(String codeAuthorization) {
        this.codeAuthorization = codeAuthorization;
    }

    /**
     * Сравниваем данные транзакций с помощью equals, если они равны то вернется true ,если нет то false.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transactions that = (Transactions) o;

        if (id != that.id) return false;
        if (numberAccount != null ? !numberAccount.equals(that.numberAccount) : that.numberAccount != null)
            return false;
        if (dateTransaction != null ? !dateTransaction.equals(that.dateTransaction) : that.dateTransaction != null)
            return false;
        if (operationType != null ? !operationType.equals(that.operationType) : that.operationType != null)
            return false;
        if (sumTransaction != null ? !sumTransaction.equals(that.sumTransaction) : that.sumTransaction != null)
            return false;
        if (currencyType != null ? !currencyType.equals(that.currencyType) : that.currencyType != null) return false;
        if (terminalId != null ? !terminalId.equals(that.terminalId) : that.terminalId != null) return false;
        if (codeAuthorization != null ? !codeAuthorization.equals(that.codeAuthorization) : that.codeAuthorization != null)
            return false;

        return true;
    }

    /**
     * Сравниваем данные транзакций с помощью hashCode, если они равны то вернется true ,если нет то false.
     * @return
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numberAccount != null ? numberAccount.hashCode() : 0);
        result = 31 * result + (dateTransaction != null ? dateTransaction.hashCode() : 0);
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + (sumTransaction != null ? sumTransaction.hashCode() : 0);
        result = 31 * result + (currencyType != null ? currencyType.hashCode() : 0);
        result = 31 * result + (terminalId != null ? terminalId.hashCode() : 0);
        result = 31 * result + (codeAuthorization != null ? codeAuthorization.hashCode() : 0);
        return result;
    }

    /**
     * Выводим всю информацию по транзакциям
     * @return
     */
    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", numberAccount='" + numberAccount + '\'' +
                ", dateTransaction=" + dateTransaction +
                ", operationType=" + operationType +
                ", sumTransaction=" + sumTransaction +
                ", currencyType=" + currencyType +
                ", terminalId='" + terminalId + '\'' +
                ", codeAuthorization='" + codeAuthorization + '\'' +
                '}';
    }
}
