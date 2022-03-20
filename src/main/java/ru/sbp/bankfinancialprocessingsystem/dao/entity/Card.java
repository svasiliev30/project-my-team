package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.springframework.stereotype.Component;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CardStatusType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.CardsRepository;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Класс Cards - POJO-класс (Plain Old Java Object) таблицы cards
 *
 * @autor Evgeniy Nochkin
 * @version 1.0
 */
@Component
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Integer id;

    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @OneToOne(mappedBy = "card")
    private Account numberAccount;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "payment_system")
    @Enumerated(EnumType.STRING)
    private PaymentSystemType paymentSystem;

    @Column(name = "card_status")
    @Enumerated(EnumType.STRING)
    private CardStatusType cardStatus;

    public Card() {
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Account numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public PaymentSystemType getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystemType paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public CardStatusType getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatusType cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(cardNumber, card.cardNumber) && Objects.equals(numberAccount, card.numberAccount) && Objects.equals(expirationDate, card.expirationDate) && Objects.equals(cardHolderName, card.cardHolderName) && paymentSystem == card.paymentSystem && cardStatus == card.cardStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, numberAccount, expirationDate, cardHolderName, paymentSystem, cardStatus);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", numberAccount=" + numberAccount +
                ", expirationDate=" + expirationDate +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", paymentSystem=" + paymentSystem +
                ", cardStatus=" + cardStatus +
                '}';
    }
}
