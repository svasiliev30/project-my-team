package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Класс ServerController содержит методы реализации REST-контроллера
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
@RestController
@RequestMapping("/bank")
public class ServerController {

    private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

    @Value("${appName}")
    private String appName;

    @Value("${dbType}")
    private String dbType;

    @Autowired
    private GlobalUserRepository globalUserRepository;

    @Autowired
    private BankDataRepository bankDataRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CardsRepository cardsRepository;

    /**
     * Метод index выполняет тестирование сервисов Сервера
     * GET http://localhost:8080/bank/test
     *
     * @return - String информационная строка
     */
    @RequestMapping("/test")
    public String index() {

        String responseString = appName + "<br>" + " DBMS=" + dbType + "<br>" + "Our development team: sproshchaev@gmail.com, evgenusn@gmail.com, vasiljevserj777@gmail.com, clame023@gmail.com, konstfilin1962@gmail.com" + "<br>" + "Сurrent date and time: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "<br>";

        logger.info("Test globalUserRepository.existsById(\"admin\")=" + globalUserRepository.existsById("admin"));
        responseString = responseString + "Test globalUserRepository=" + globalUserRepository.existsById("admin") + ", <br>";

        logger.info("Test bankDataRepository.existsById(1)=" + bankDataRepository.existsById(1));
        responseString = responseString + "Test bankDataRepository.existsById(1)=" + bankDataRepository.existsById(1) + ", <br>";

        logger.info("Test bankDataRepository.count()=" + clientsRepository.count());
        responseString = responseString + "Test bankDataRepository.count()=" + clientsRepository.count() + ", <br>";

        logger.info("Test accountsRepository.count()=" + accountRepository.count());
        responseString = responseString + "Test accountsRepository.count()=" + accountRepository.count() + ", <br>";

        logger.info("Test accountsRepository.count()=" + accountRepository.count());
        responseString = responseString + "Test accountsRepository.count()=" + accountRepository.count() + ", ";

        logger.info("Test transactionsRepository.count()=" + transactionsRepository.count());
        responseString = responseString + "Test transactionsRepository.count()=" + transactionsRepository.count() + ", <br>";

        List<Transactions> transactions = new ArrayList<>((Collection) transactionsRepository.findAll());
        responseString = responseString + "TransactionsRepository: <br>" + transactions.toString() + ", <br>";

        logger.info("Test cardsRepository.count()=" + cardsRepository.count());
        responseString = responseString + "Test cardsRepository.count()=" + cardsRepository.count() + ". <br>";

        return responseString;
    }

    /**
     * Метод index выполняет тестирование сервисов Сервера
     * GET http://localhost:8080/bank/test
     * @return - String информационная строка
     */
    @RequestMapping("/clients")
    public String getAllClients() {

        String responseString = appName + "\n" + " DBMS=" + dbType + "\n" + "Сurrent date and time: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "\n";

        logger.info("Test bankDataRepository.count()=" + clientsRepository.count());
        responseString = responseString + "Test bankDataRepository.count()=" + clientsRepository.count() + ", ";

        return responseString;
    }
}
