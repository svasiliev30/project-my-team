package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.OperationType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.TransactionsRepository;
import ru.sbp.bankfinancialprocessingsystem.service.account.AccountService;
import ru.sbp.bankfinancialprocessingsystem.service.account.TransactionAccount;
import ru.sbp.bankfinancialprocessingsystem.service.account.СalculationsAccount;

import java.util.List;

/**
 * @autor Sergey Vasiliev
 */
@Controller
@RequestMapping(value = "/account")
public class UserAccount {

    /**
     * Cвязь с репозиторием аккаунта в бд
     */
    @Autowired
    private AccountRepository repository;

    /**
     * Связь с ентити аккаунта.
     */
    @Autowired
    Account account;

    /**
     * вызов калькулятора
     */
    @Autowired
    private СalculationsAccount сalculations;

    /**
     * Запись транзакции в bd.
     */
    @Autowired
    private TransactionAccount transactionAccount;

    /**
     * Вызов контроллера для ссылки на ошибку
     */
    @Autowired
    private ErorrAccount erorr;

    /**
     * Сервис по созданию нового счета.
     */
    @Autowired
    private AccountService service;

    /**
     * Связь с bd транзакций
     */
    @Autowired
    private TransactionsRepository transRepository;

    /**
     * Номер счета
     */
    private String numberAccount;

    /**
     * новый номер счета
     */
    private String newNumber;

    /**
     * Количество денег
     */
    private double money;

    /**
     * Получаем информацию по логину
     */
    private String userLogin;
    @GetMapping(value = "/add/{userLogin}")
    public ModelAndView getInformationLogin(@PathVariable(value = "userLogin") String userLogin) {

        this.userLogin = userLogin;

        return this.getInformationAboutCheck();
    }

    /**
     * Получаем информацию по номеру счета
     */
    @GetMapping(value = "/info/{accountNumber}")
    public ModelAndView getInformationNumber(@PathVariable(value = "accountNumber") String accountNumber) {
        this.newNumber = accountNumber;
        this.numberAccount = accountNumber;
        this.account = repository.findByNumberAccount(newNumber);

        return this.getInformationAboutCheck();
    }

    /**
     * Отправляет информацию по наименованию клиента(name), номеру аккаунта(accountNumber),
     * активному статусу(activityStatus), балансу счета(balance), дате открытия (dateOpen),
     * тип валюты(currency)
     *  Если номер счета не создан, то переводит на создание нового счета.
     * @return
     */
    @GetMapping(value = "/info")
    public ModelAndView getInformationAboutCheck() {

        if(newNumber == null) {
            try {
                List<Account> listAcc = repository.findByUserLogin(userLogin);
               if (listAcc.size() != 0) {
                   account = listAcc.get(0);
                   account.getNumberAccount();
               }
            } catch (NullPointerException e) {
                return this.getInformationCreateNumberAccount();
            }
            return this.getInformationCreateNumberAccount();
        }

        account = repository.findByNumberAccount(numberAccount);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("account/account.jsp");

        try {
            modelAndView.addObject("login", account.getUserLogin());
            modelAndView.addObject("accountNumber",account.getNumberAccount());
            modelAndView.addObject("dateOpen", account.getDateOpen());
            modelAndView.addObject("activityStatus", account.getAccountActive());
            modelAndView.addObject("balance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
            try{

                String cardNumber = account.getCard().getCardNumber();
                modelAndView.addObject("card", cardNumber );
                return modelAndView;
            }catch (NullPointerException e){
                modelAndView.addObject("card", "-" );
                return modelAndView;
            }
        }catch (NullPointerException e){
            modelAndView.addObject("login", userLogin);
            modelAndView.addObject("accountNumber","-");
            modelAndView.addObject("card", "-" );
            modelAndView.addObject("dateOpen","-" );
            modelAndView.addObject("activityStatus", "-");
            modelAndView.addObject("balance", "");
            modelAndView.addObject("currency", "-");
            return modelAndView;
        }
    }

    /**
     * Получаем номер счета и выводим информацию по нему.
     * @param numberAccount
     * @return
     */
    @PostMapping(value = "/info")
    public ModelAndView updateInformation(
            @RequestParam("numberAccount") String numberAccount){

        this.numberAccount = numberAccount;
        account = repository.findByNumberAccount(numberAccount);
        try {
            account.getNumberAccount();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            return erorr.getErorrNumberInfo();
        }
        return this.getInformationAboutCheck();
    }

    /**
     * Выводит информацию по счету.
     *   Eсли номера счета нет в Базе данных, то numberAccount = null,
     * это нужно,чтоб когда человек вводил номера, которого нет,
     * то при возвращении на страничку /updateDeposit выходило бы
     * сообщение "Введите пожалуйста номер счета".
     *   Если номер счета верный,то выводит информацию о счете
     *   В самом первом входе на стриничку счет неопределен, поэтому
     * numberAccount == null и будет выводится информация "Введите
     * пожалуйста номер счета".
     * @return
     */
    @GetMapping(value = "/info/updateDeposit")
    public ModelAndView getInformationDepositCash() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/depositMoney.jsp");

        if((account = repository.findByNumberAccount(numberAccount)) == null){
            this.numberAccount = null;
        }
        if(!(numberAccount == null)) {
            account = repository.findByNumberAccount(numberAccount);
            modelAndView.addObject("newBalance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
        }else {
            modelAndView.addObject("newBalance",
                    "Введите пожалуйста номер счета");
        }
        return modelAndView;
    }

    /**
     * Принимает параметры "moneyString".
     * По номеру счета суммируется поступившая сумма с суммой из bd.
     * Получаемая сумма сохраняется в bd и выводится новая информация
     * getInformationDepositCash().
     *      Если user не ввел вносимую сумму "money = "" "то
     * money = 0 и выводится неизмененная информация по сумме.
     *      Если номер счета не введен или введен тот, которого его
     * нет в bd, выскакивает окно с просьбой проверить № или
     * создать новый.
     *    Также записывается транзакция в бд.
     * @param moneyString
     * @return
     */
    @PostMapping(value = "/info/updateDeposit")
    public ModelAndView updateDeposit(
            @RequestParam("money") String moneyString){

        if("" == moneyString ){
            money = 0;
        }else {
            money = Double.parseDouble(moneyString);
        }
        account = repository.findByNumberAccount(numberAccount);
        сalculations.setNewBalanceAndNumberAccount(money,numberAccount);

        try {
            сalculations.amountOfMoney();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            e.fillInStackTrace();
            return erorr.getErorrNumberInfo();
        }
        transactionAccount.setInformation(account.getNumberAccount(),
                OperationType.CashIn, money);
        transactionAccount.createNewAccount();

        account.setBalance(сalculations.getNewBalance());
        System.out.println(account.toString());
        repository.save(account);

        return this.getInformationDepositCash();
    }

    /**
     * Выводит информацию по счету.
     *  Eсли номера счета нет в Базе данных, то numberAccount = null,
     * это нужно,чтоб когда человек вводил номер, которого нет,
     * то при возвращении на страничку /withdrawCash выходило бы
     * сообщение "Введите пожалуйста номер счета".
     *  Если номер счета верный,то выводит информацию о счете -
     * account.getBalance().
     *  Если выводимая сумма больше баланса счета то выводит сообщение
     * "Ошибка! недостаточно средств на счету."
     * @return
     */
    @GetMapping(value = "/info/withdrawCash")
    public ModelAndView getInformationWithdrawСash () {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/withdrawCash.jsp");

        account = repository.findByNumberAccount(numberAccount);

        if(!(numberAccount == null)) {
            modelAndView.addObject("newBalance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
        }else {
            modelAndView.addObject("newBalance",
                    "Введите пожалуйста номер счета");
            return modelAndView;
        }
        if (сalculations.getNewBalance() < 0){

            modelAndView.addObject("newBalance", сalculations.getOldBalance());
            modelAndView.addObject("currency", account.getCurrency());
            modelAndView.addObject("errorBalance", "Ошибка! недостаточно средств на счету.");
            return modelAndView;
        }
        if((account = repository.findByNumberAccount(numberAccount)) == null){
            this.numberAccount = null;
        }
        return modelAndView;
    }

    /**
     * Принимает параметры "moneyString".
     * По номеру счета вычетается поступившая сумма с суммой из bd.
     * Получаемая сумма сохраняется в bd и выводится новая информация
     * getInformationDepositCash().
     *      Если user не ввел вносимую сумму "money = "" " то
     * money = 0 и выводится неизмененная информация по сумме.
     *      Если номер счета не введен или введен тот, которого его
     * нет в bd, выскакивает окно с просьбой проверить Номер счета или
     * создать новый.
     *      Также записывается транзакция в бд.
     * @param moneyString
     * @return
     */
    @PostMapping(value = "/info/withdrawCash")
    public ModelAndView updateWithdraw(
            @RequestParam("money") String moneyString){

        if("" == moneyString ){
            money = 0;
        }else {
            money = Double.parseDouble(moneyString);
        }
        account = repository.findByNumberAccount(numberAccount);
        сalculations.setNewBalanceAndNumberAccount(money,numberAccount);

        try {
            сalculations.withdrawOfMoney();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            e.fillInStackTrace();
            return erorr.getErorrNumberInfo();
        }
        if (сalculations.getNewBalance() < 0){
            return this.getInformationWithdrawСash();
        }
        transactionAccount.setInformation(account.getNumberAccount(),
                OperationType.CashOut, money);
        transactionAccount.createNewAccount();

        account.setBalance(сalculations.getNewBalance());
        repository.save(account);

        return this.getInformationWithdrawСash();
    }

    /**
     * Выводит логин и новый номер счета
     * @return
     */
    @GetMapping(value = "/info/createAnAccount")
    public ModelAndView getInformationCreateNumberAccount() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/createsAnAccount.jsp");
        modelAndView.addObject("userLogin", userLogin);
        modelAndView.addObject("accountNumber", newNumber);

        return modelAndView;
    }

    /**
     * Получаем тип счета и тип аккаунта
     * и создаем новый счет при перезагрузки странички
     * @param accountType
     * @param currency
     * @return
     */
    @PostMapping(value = "/info/createAnAccount")
    public ModelAndView updateDeposit(
            @RequestParam("accountType") String accountType,
            @RequestParam("currency") String currency){
        service.setInformation(currency,accountType,userLogin);
        this.newNumber = service.createNewAccount();

        return this.getInformationCreateNumberAccount();
    }

    /**
     * Выводим всю информацию по транзакциям по определенному счету.
     * Если счета нет, то выбрасываем ошибку о созданиии или вводе счета.
     * @return
     */
    @GetMapping(value = "/info/accountStatement")
    public ModelAndView getInformationAboutTransaction() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/accountStatement.jsp");
        try {
            List<Transactions> transactionList = transRepository.getInformationAboutTrans(numberAccount);

            modelAndView.addObject("login", account.getUserLogin());
            modelAndView.addObject("transactionList", transactionList);
            modelAndView.addObject("accountNumber", account.getNumberAccount());
            modelAndView.addObject("balance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
            return modelAndView;
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            e.fillInStackTrace();
            return erorr.getErorrNumberInfo();
        }
    }
}
