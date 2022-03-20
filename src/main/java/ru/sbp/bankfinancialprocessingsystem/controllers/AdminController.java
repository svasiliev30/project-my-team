package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.service.CustomUserDetailedService;


import java.util.Date;
import java.util.List;

/**
 * @author Konstantin Filin
 */


@Controller
public class AdminController {
    @Autowired
    private CustomUserDetailedService userBankService;

    /**
     * метод showAll обрабатывает GET запрос от браузера с мэппингом /all,
     * получает всех пользователей из БД и отображает их в форме showall.jsp
     *
     */
    @GetMapping("/showall")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showall.jsp");
        List<Clients> userList = userBankService.allUsers();
        modelAndView.addObject("todaydata", new Date().toString());
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }
}




