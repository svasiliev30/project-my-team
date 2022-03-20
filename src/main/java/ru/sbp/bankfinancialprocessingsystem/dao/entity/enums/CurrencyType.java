package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;

/**
 * Класс enum содержит описание значений поля в таблие accounts.currency
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see Account#Object()
 */
public enum CurrencyType {
    RUB,
    EUR,
    USD;

    CurrencyType() {
    }

}
