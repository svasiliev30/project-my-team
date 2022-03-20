package ru.sbp.bankfinancialprocessingsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.service.CardService;

/**
 * Класс BankFinancialProcessingSystemApplication является точкой входа в проект
 * @autor Sergey Proshchaev
 * @version 1.0
 *
 */

/**
 * @author Konstantin Filin
 */


@SpringBootApplication
public class BankFinancialProcessingSystemApplication {

	private static final Logger logger = LoggerFactory.getLogger(BankFinancialProcessingSystemApplication.class);

	public static void main(String[] args) {


		logger.info("BankFinancialProcessingSystemApplication run...");

		SpringApplication.run(BankFinancialProcessingSystemApplication.class, args);
	}
}