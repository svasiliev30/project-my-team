package ru.sbp.bankfinancialprocessingsystem.cardutil;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;
import ru.sbp.bankfinancialprocessingsystem.service.CardService;

import java.util.ArrayList;
import java.util.List;

/**
 * Утилиты для формирования номера карты
 *
 * @author Evgeniy Nochkin
 * @version 1.0
 */
public class CardUtil {

    @Autowired
    CardService service;

    private final static String BANK_NUMBER = "111";
    private final static String BANK_PROD = "01";

    /**
     * Формирование нового номера карты в соответствии с типом
     * @param list список имеющихся карт
     * @param type тип новой карты
     * @return новый номер
     */
    public static String getNumberCard(List<Card> list, PaymentSystemType type) {
        String result = "";
        result = result + new CardTypesList().getBICBank(type);
        result = result + BANK_NUMBER;
        result = result + BANK_PROD;
        result = result + getStringNumber(getCountRecords(list, type) + 1);
        result = getLastNumber(result);

        return result;
    }

    /**
     * Формирование номера карты
     * @param num номер карты в Integer
     * @return номер карты в String
     */
    private static String getStringNumber(Integer num) {
        char[] card = {'0', '0', '0', '0', '0', '0', '0', '0', '0'};

        char[] inputNum = ("" + num).toCharArray();
        int j = inputNum.length - 1;

        for (int i = card.length - 1; i >= 0 & j >= 0; i--) {
                card[i] = inputNum[j];
                j--;
        }

        return new String(card);
    }

    /**
     * Поиск максимального номера карты по ее типу
     * @param list список всех номеров карты
     * @param type тип добавляемой карты
     * @return максимальный номер карты по типу
     */
    private static Integer getCountRecords(List<Card> list, PaymentSystemType type) {
        if (list.size() == 0) return 0;

        List<String> cardsListOnType = new ArrayList<>();
        byte code = new CardTypesList().getBICBank(type);

        for (Card card : list) {
            if (card.getCardNumber().substring(0, 1).equals(Byte.toString(code)))
                cardsListOnType.add(card.getCardNumber());
        }

        if (cardsListOnType.size() == 0) return 0;

        List<Integer> cods = new ArrayList<>();
        for (String c : cardsListOnType) {
            cods.add(Integer.parseInt(c.substring(6, 15)));
        }

        Integer max = 0;
        for (int i = 0; i < cods.size(); ++i) {
            if (cods.get(i) > max)
                max = cods.get(i);
        }

        return max;
    }

    /**
     * Добавление последней цифры номера карты подходящего под алгоритм Луна
     * @param str 15 цифр номера карты
     * @return удовлетворяющий условие номер карты
     */
    private static String getLastNumber(String str) {
        Integer add = 0;
        String result = str + add;
        while(!isValidLuhn(result)) {
            add++;
            result = str + add;
        }

        return result;
    }

    /**
     * Алгоритм Луна
     * @param value проверяемый номер
     * @return true если соответствует алгоритму Луна
     */
    private static boolean isValidLuhn(String value) {
        int sum = Character.getNumericValue(value.charAt(value.length() - 1));
        int parity = value.length() % 2;
        for (int i = value.length() - 2; i >= 0; i--) {
            int summand = Character.getNumericValue(value.charAt(i));
            if (i % 2 == parity) {
                int product = summand * 2;
                summand = (product > 9) ? (product - 9) : product;
            }
            sum += summand;
        }
        return (sum % 10) == 0;
    }
}
