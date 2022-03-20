package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;

/**
 * Класс enum содержит описание значений поля в таблие cards.payment_system
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see Card#Object()
 */
public enum PaymentSystemType {
    VISA,
    MC,
    МИР;

    PaymentSystemType() {
    }

}
