package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @autor Sergey Vasiliev
 */
@Controller
@RequestMapping(value = "/erorr")
public class ErorrAccount {

    /**
     * Возвращает страничку с ошибкой, если введенная информация
     * не соответствует требуемым требованиям.
     * @return
     */
    @GetMapping(value = "/erorrNumber")
    public ModelAndView getErorrNumberInfo() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account/erorrNumber.jsp");
        return modelAndView;
    }
}
