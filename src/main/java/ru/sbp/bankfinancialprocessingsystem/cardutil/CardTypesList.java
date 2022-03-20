package ru.sbp.bankfinancialprocessingsystem.cardutil;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;

import java.util.EnumMap;

/**
 * Карта типов карт с номером системы для БИН
 *
 * @author Evgeniy Nochkin
 * @version 1.0
 */
public class CardTypesList {

    private static EnumMap<PaymentSystemType, Byte> cardTypesList = new EnumMap<PaymentSystemType, Byte>(PaymentSystemType.class);

    static {
        cardTypesList.put(PaymentSystemType.VISA, (byte) 4);
        cardTypesList.put(PaymentSystemType.MC, (byte) 5);
        cardTypesList.put(PaymentSystemType.МИР, (byte) 6);
    }

    /**
     * Получения номера системы для БИН по типу карты
     * @param type тип карты
     * @return номер системы для БИН
     */
    public byte getBICBank(PaymentSystemType type) {
        return cardTypesList.get(type);
    }
}
