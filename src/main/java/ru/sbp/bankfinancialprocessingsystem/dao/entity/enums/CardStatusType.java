package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;


import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;

/**
 * Класс enum содержит описание значений поля в таблие cards.card_status
 * @autor Sergey Proshchaev
 * @version 1.0
 * @see Card#Object()
 */
public enum CardStatusType {
    Valid,
    Lost,
    Expired;

    CardStatusType() {
    }

}
