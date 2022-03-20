package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;

/**
 * Класс enum содержит описание значений поля в таблие accounts.account_type
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see Account#Object()
 */
public enum AccountType {
     Current,
     Card,
     Savings;

     AccountType() {
     }

}
