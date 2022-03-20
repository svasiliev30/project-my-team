package ru.sbp.bankfinancialprocessingsystem.service.account;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.TransactionsRepository;

/**
 * Сервис для генерации номера счета.
 * @autor Sergey Vasiliev
 */
@Service
public class GeneratedNumber {

    /**
     * Вызов у application.properties данных.
     * @param lenghtCodeAuthorization
     */
    @Value(value = "${lenght.code.authorization}")
    public void setlenghtCodeAuthorization (int lenghtCodeAuthorization) {
        this.lenghtCodeAuthorization = lenghtCodeAuthorization;
    }

    /**
     * Вызов у application.properties данных.
     * @param lenghtNumberTerminalId
     */
    @Value("${lenght.number.terminal.id}")
    public void setLenghtNumberTerminalId(int lenghtNumberTerminalId) {
        this.lenghtNumberTerminalId = lenghtNumberTerminalId;
    }

    /**
     * Вызов у application.properties данных.
     * @param lenghtNumberCard
     */
    @Value("${length.number.card}")
    public void setLenghtNumberCard(int lenghtNumberCard) {
        this.lenghtNumberCard = lenghtNumberCard;
    }

    /**
     * Вызов entity для работы с db.
     */
    @Autowired
    private Account account;

    /**
     * Связь с Entity транзакций
     */
    @Autowired
    private Transactions transactions;

    /**
     * Связь с репозиторием транзакций в bd
     */
    private TransactionsRepository repTransaction;

    /**
     * Связь с репозеторием db.
     */
    private AccountRepository repository;

    /**
     * Номер нового счета.
     */
    private String newNumberCard;

    /**
     * Настраиваемая длинна счета.
     */
    private int lenghtNumberCard;

    /**
     * Настраиваемая длинна терминала
     */
    private int lenghtNumberTerminalId;
   
    /**
     * Настройка длинны кода авторизации
     */
    private int lenghtCodeAuthorization;

    public GeneratedNumber(){
    }

    /**
     * Присваиваем репозиторий транзакций.
     * @param repTransaction
     */
    @Autowired
    public void setRepTransaction(TransactionsRepository repTransaction) {
        this.repTransaction = repTransaction;
    }

    /**
     * Присваиваем репозиторий аккаунта.
     * @param repository
     */
    @Autowired
    public void setRepository(AccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Генерация нового номера счета и проверка ,что такого номера
     * нет в bd c помощью NullPointerException.
     * @return
     * @throws NullPointerException
     */
    public String getNumberAccount() throws NullPointerException{

        int x = 0;
        do{
         newNumberCard = RandomStringUtils.randomNumeric(lenghtNumberCard);
         account = repository.findByNumberAccount(newNumberCard);
            try {
                account.getNumberAccount();
            }catch(NullPointerException e){
                System.out.println("Creating number account");
                return newNumberCard;
            }
            x++;
        }while (x > 0);
        return null;
    }

    /**
     * Генерация нового номера банкомата
     * @return
     * @throws NullPointerException
     */
    public String getNumberTerminalId() throws NullPointerException{
            newNumberCard = RandomStringUtils.randomNumeric(lenghtNumberTerminalId);

        return newNumberCard;
    }

    /**
     * Генерация нового кода авторизации и проверка ,что такого номера
     * нет в bd c помощью NullPointerException.
     * @return
     * @throws NullPointerException
     */
    public String getNumberCodeAuthorization() throws NullPointerException{
        int x = 0;
        do{
            newNumberCard = RandomStringUtils.randomNumeric(lenghtCodeAuthorization);
            transactions = repTransaction.findByCodeAuthorization(newNumberCard);
            try {
                transactions.getCodeAuthorization();
            }catch(NullPointerException e){
                System.out.println("Creating number authorization");
                return newNumberCard;
            }
            x++;
        }while (x > 0);
        return null;
    }
}
