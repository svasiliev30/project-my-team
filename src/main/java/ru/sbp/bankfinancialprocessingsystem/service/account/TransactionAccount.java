package ru.sbp.bankfinancialprocessingsystem.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.OperationType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.TransactionsRepository;


/**
 * Сервис для записи транзакций.
 * @autor Sergey Vasiliev
 */
@Service
public class TransactionAccount {

    /**
     * Связь с Entity транзакций
     */
    @Autowired
    private Transactions transactions;

    /**
     * Связь с репозиторием транзакций в bd
     */
    @Autowired
    private TransactionsRepository repository;

    /**
     * Генерация чисел
     */
    @Autowired
    private GeneratedNumber generated;

    private String numberAccount;
    private OperationType operationType;
    private Double sumTransaction;

    /**
     * Пустой конструктор.
     */
    public TransactionAccount(){

    }

    /**
     * Получаем информацию для записи транзакции.
     * @param numberAccount
     * @param operationType
     * @param sumTransaction
     */
    public void setInformation(String numberAccount, OperationType operationType,
                                       Double sumTransaction) {
        this.numberAccount = numberAccount;
        this.operationType = operationType;
        this.sumTransaction = sumTransaction;

    }

    /**
     * Создаем новую транзакцию и сохраняем в bd.
     * @return
     */
    public boolean createNewAccount() {
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        transactions.setId(Integer.valueOf(generated.getNumberTerminalId()));
        transactions.setNumberAccount(numberAccount);
        transactions.setSumTransaction(sumTransaction);
        transactions.setDateTransaction(date);
        transactions.setOperationType(operationType);
        transactions.setCodeAuthorization(generated.getNumberCodeAuthorization());
        transactions.setCurrencyType(CurrencyType.RUB);
        transactions.setTerminalId(generated.getNumberTerminalId());
        repository.save(transactions);

        return true;
    }
}
