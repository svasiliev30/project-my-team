package ru.sbp.bankfinancialprocessingsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.TransactionsRepository;
import ru.sbp.bankfinancialprocessingsystem.service.account.GeneratedNumber;
import ru.sbp.bankfinancialprocessingsystem.service.account.СalculationsAccount;

class BankFinancialProcessingSystemApplicationTests {

	/**
	 * @autor Sergey Vasiliev
	 * Генерация номера счета длинной 20 символов и отличный от изначального
	 */
	@Test
	public void  testNumberAccountGenerated() {
		String newNumberCard = "12345678901234567890";
		int i = 20;

		Account account = new Account();
		GeneratedNumber generatedNumber = new GeneratedNumber();

		generatedNumber.setLenghtNumberCard(i);
		AccountRepository repository = Mockito.mock(AccountRepository.class);
		Mockito.when(repository.findByNumberAccount(newNumberCard)).thenReturn(account);

		generatedNumber.setRepository(repository);
		Assertions.assertEquals(i,generatedNumber.getNumberAccount().length());

		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
	}

	/**
	 * @autor Sergey Vasiliev
	 * Генерация номера счета длинной 10 символов и отличный от изначального
	 */
	@Test
	public void  testNumberAccountGeneratedLenghtTen() {
		String newNumberCard = "1234567890";
		int i = 10;

		Account account = new Account();
		GeneratedNumber generatedNumber = new GeneratedNumber();
		generatedNumber.setLenghtNumberCard(i);
		AccountRepository repository = Mockito.mock(AccountRepository.class);
		Mockito.when(repository.findByNumberAccount(newNumberCard)).thenReturn(account);

		generatedNumber.setRepository(repository);
		Assertions.assertEquals(i,generatedNumber.getNumberAccount().length());

		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberAccount());
	}

	/**
	 * @autor Sergey Vasiliev
	 * Генерация id терминала длинной 6 символов
	 */
	@Test
	public void  testNumberTerminalIdGeneratedLengthSix() {

		int i = 6;
		Account account = new Account();
		GeneratedNumber generatedNumber = new GeneratedNumber();
		generatedNumber.setLenghtNumberTerminalId(i);

		Assertions.assertEquals(i,generatedNumber.getNumberTerminalId().length());
	}

	/**
	 * @autor Sergey Vasiliev
	 * Генерация id терминала длинной 10 символов
	 */
	@Test
	public void  testNumberTerminalIdGeneratedLengthTen() {

		int i = 10;
		Account account = new Account();
		GeneratedNumber generatedNumber = new GeneratedNumber();
		generatedNumber.setLenghtNumberTerminalId(i);

		Assertions.assertEquals(i,generatedNumber.getNumberTerminalId().length());
	}

	/**
	 * @autor Sergey Vasiliev
	 * Генерация номера авторизации длинной 8 символов и отличный от изначального
	 */
	@Test
	public void  testNumberCodeAuthorization() {
		String newNumberCard = "12345678";
		int i = 8;

		Transactions transactions = new Transactions();
		GeneratedNumber generatedNumber = new GeneratedNumber();
		generatedNumber.setlenghtCodeAuthorization(i);
		TransactionsRepository repository = Mockito.mock(TransactionsRepository.class);
		Mockito.when(repository.findByNumberAccount(newNumberCard)).thenReturn(transactions);

		generatedNumber.setRepTransaction(repository);
		Assertions.assertEquals(i,generatedNumber.getNumberCodeAuthorization().length());

		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
	}
	/**
	 * @autor Sergey Vasiliev
	 * Генерация номера авторизации длинной 15 символов и отличный от изначального
	 */
	@Test
	public void  testNumberCodeAuthorizatiLenghtOne() {
		String newNumberCard = "123456789012345";
		int i = 15;

		Transactions transactions = new Transactions();
		GeneratedNumber generatedNumber = new GeneratedNumber();
		generatedNumber.setlenghtCodeAuthorization(i);
		TransactionsRepository repository = Mockito.mock(TransactionsRepository.class);
		Mockito.when(repository.findByNumberAccount(newNumberCard)).thenReturn(transactions);

		generatedNumber.setRepTransaction(repository);
		Assertions.assertEquals(i,generatedNumber.getNumberCodeAuthorization().length());

		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
		Assertions.assertNotEquals(newNumberCard,generatedNumber.getNumberCodeAuthorization());
	}

	/**
	 * @autor Sergey Vasiliev
	 * Тестируем суммирование сумм:
	 * newBalance = 11;
	 * newBalance = 21;
	 * newBalance = 121.8;
	 * oldBalance = 10.5;
	 * Также вывод нового значения и старого значения.
	 */
	@Test
	public void  testCalculationAmountOfMoney() {
		СalculationsAccount calAccount = new СalculationsAccount();
		String NumberCard = "12345678901234567890";
		double newBalance = 11;
		double oldBalance = 10.5;

		Account account = Mockito.mock(Account.class);
		Mockito.when(account.getBalance()).thenReturn(oldBalance);

		AccountRepository repository = Mockito.mock(AccountRepository.class);
		Mockito.when(repository.findByNumberAccount(NumberCard)).
				thenReturn(account);

		calAccount.setRepository(repository);
		calAccount.setEntity(account);
		calAccount.setNewBalanceAndNumberAccount(newBalance,NumberCard);
		calAccount.amountOfMoney();

		Assertions.assertEquals(newBalance + oldBalance,
				calAccount.getNewBalance());

		Assertions.assertEquals(oldBalance,
				calAccount.getOldBalance());

		newBalance = 21;
		calAccount.setNewBalanceAndNumberAccount(newBalance,NumberCard);
		calAccount.amountOfMoney();

		Assertions.assertEquals(newBalance + oldBalance,
				calAccount.getNewBalance());

		newBalance = 121.8;
		calAccount.setNewBalanceAndNumberAccount(newBalance,NumberCard);
		calAccount.amountOfMoney();

		Assertions.assertEquals(newBalance + oldBalance,
				calAccount.getNewBalance());
	}

	/**
	 * @autor Sergey Vasiliev
	 * Тестируем суммирование сумм:
	 * newBalance = 10;
	 * newBalance = 21.3;
	 * newBalance = 121.8;
	 * oldBalance = 150;
	 * Также вывод нового значения и старого значения.
	 */
	@Test
	public void  testCalculationWithdrawOfMoney() {
		СalculationsAccount calAccount = new СalculationsAccount();
		String NumberCard = "12345678901234567890";
		double newBalance = 10;
		double oldBalance = 150;

		Account account = Mockito.mock(Account.class);
		Mockito.when(account.getBalance()).thenReturn(oldBalance);

		AccountRepository repository = Mockito.mock(AccountRepository.class);
		Mockito.when(repository.findByNumberAccount(NumberCard)).
				thenReturn(account);

		calAccount.setRepository(repository);
		calAccount.setEntity(account);
		calAccount.setNewBalanceAndNumberAccount(newBalance,NumberCard);
		calAccount.withdrawOfMoney();

		Assertions.assertEquals( oldBalance - newBalance,
				calAccount.getNewBalance());

		Assertions.assertEquals(oldBalance,
				calAccount.getOldBalance());

		newBalance = 21.3;
		calAccount.setNewBalanceAndNumberAccount(newBalance,NumberCard);
		calAccount.withdrawOfMoney();

		Assertions.assertEquals( oldBalance - newBalance,
				calAccount.getNewBalance());

		newBalance = 121.8;
		calAccount.setNewBalanceAndNumberAccount(newBalance,NumberCard);
		calAccount.amountOfMoney();

		Assertions.assertEquals(newBalance + oldBalance,
				calAccount.getNewBalance());
	}
}
