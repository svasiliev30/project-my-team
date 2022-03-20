package ru.sbp.bankfinancialprocessingsystem.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс PosController содержит методы реализующие функционал обработки запросов на соверщение операций по банковским картам
 * от торговой точки (POS - point of sale)
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
@Controller
@RequestMapping(value = "/pos")
public class PosController {

   // @Value("${terminalid}")
    private String terminalId;

   // @Value("${address}")
    private String address;

    @GetMapping
    public ModelAndView info() {
        ModelAndView modelAndView = new ModelAndView("/views/pos_info.jsp");
        modelAndView.addObject("tid", "Terminal ID: " + terminalId);
        modelAndView.addObject("sale_name", "Computer store");
        modelAndView.addObject("address", "Address: " + address);
        modelAndView.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public ModelAndView adminPage() {
        ModelAndView paymentCardView = new ModelAndView("/views/pos_admin.jsp");
        return paymentCardView;
    }

    @GetMapping(value = "/pay")
    public ModelAndView paymentCard(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView paymentCardView = new ModelAndView("/views/pos_pay_card.jsp");
        return paymentCardView;
    }

    @PostMapping(value = "/createtrans")
    public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam("card") String cardNumber,
                                          @RequestParam("dateexp") String dateExp,
                                          @RequestParam("summa") String summa) {

        System.out.println("Авторизация: " + cardNumber + " " + dateExp + " " + summa + "RUB");

        ModelAndView authorizationResult = new ModelAndView("/views/pos_auth_result.jsp");
        authorizationResult.addObject("tid", "Terminal ID: 000001");
        authorizationResult.addObject("sale_name", "Computer store");
        authorizationResult.addObject("address", "ul. Kosmonavtov 35, Vyborg, Leningradskaya oblast, RUSSIA");
        authorizationResult.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        authorizationResult.addObject("codeAutor", "123456");

        return authorizationResult;
    }

    //
    @PostMapping(value = "/createrefund")
    public ModelAndView createRefund(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam("card") String cardNumber,
                                          @RequestParam("codeauth") String codeauth,
                                          @RequestParam("summa") String summa) {

        System.out.println("Возврат: " + cardNumber + " " + codeauth + " " + summa + "RUB");

        ModelAndView authorizationResult = new ModelAndView("/views/pos_auth_result.jsp");
        authorizationResult.addObject("tid", "Terminal ID: 000001");
        authorizationResult.addObject("sale_name", "Computer store");
        authorizationResult.addObject("address", "ul. Kosmonavtov 35, Vyborg, Leningradskaya oblast, RUSSIA");
        authorizationResult.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        authorizationResult.addObject("codeAutor", "123456");

        return authorizationResult;
    }

    @PostMapping(value = "/createstatement")
    public ModelAndView createStatement(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam("datebegin") String dateBegin,
                                          @RequestParam("dateend") String dateEnd
                                          ) {

        System.out.println("Выписка по операциям с : " + dateBegin + " " + dateEnd);

        ModelAndView statementResult = new ModelAndView("/views/pos_statement_result.jsp");
        statementResult.addObject("tid", "Terminal ID: 000001");
        statementResult.addObject("sale_name", "Computer store");
        statementResult.addObject("address", "ul. Kosmonavtov 35, Vyborg, Leningradskaya oblast, RUSSIA");
        statementResult.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        statementResult.addObject("dateBegin", dateBegin);
        statementResult.addObject("dateEnd", dateEnd);

        return statementResult;
    }


}
