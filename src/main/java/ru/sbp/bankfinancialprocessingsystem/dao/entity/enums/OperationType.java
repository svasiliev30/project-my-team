package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;

/**
 * Класс enum содержит описание значений поля в таблие transactions.operation_type
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see Transactions#Object()
 */
public enum OperationType {
    CashIn,
    CashOut,
    Payment,
    MoneyTransferIn,
    MoneyTransferOut,
    Refund;

    OperationType() {
    }

}
