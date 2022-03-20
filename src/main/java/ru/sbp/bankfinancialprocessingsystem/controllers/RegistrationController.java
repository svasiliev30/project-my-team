package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.GlobalUser;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.UserRoleType;
import ru.sbp.bankfinancialprocessingsystem.service.CustomUserDetailedService;


import java.time.LocalDate;
import java.util.Date;

/**
 * @author Konstantin Filin
 */

@Controller
public class RegistrationController {
    @Autowired
    private CustomUserDetailedService detailedService;

    /**
     * метод begin обрабатывает GET запрос от браузера с мэппингом /
     * и выводит приветственную форму index.jsp
     *
     */
    @GetMapping("/")
    public ModelAndView begin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }


    /**
     * Метод deleteUserByLoginGet() получает GET запрос /delete
     *  и выводит форму delete.jsp для запроса login
     */
    @GetMapping("/delete")
    public ModelAndView deleteUserByLoginGet(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteuser.jsp");
        return modelAndView;
    }

    /**
     * Метод deleteUserByLoginPost() обрабатывает Post запрос /delete
     *  и получает login для удаления
     */
    @PostMapping("/delete")
    public ModelAndView deleteUserByLoginPost(@RequestParam("login") String userlogin){
        ModelAndView modelAndView = new ModelAndView();
        GlobalUser globalUserFromDB = detailedService.getGlobalUser(userlogin);
        if(globalUserFromDB == null){
            modelAndView.addObject("userlogin", userlogin);
            modelAndView.addObject("message", " не найден");
            modelAndView.setViewName("delete_user_message.jsp");
        }else {
            Clients client = detailedService.getClient(userlogin);
            detailedService.deleteGlobalUser(userlogin);
            detailedService.deleteUserData(userlogin);
            modelAndView.addObject("userlogin", userlogin);
            modelAndView.addObject("message", " удален из БД");
            modelAndView.setViewName("delete_user_message.jsp");
        }
        return modelAndView;
    }


    /**
     * метод afterlogin обрабатывает GET запрос от браузера с мэппингом /afterlogin
     * и переходит либо на форму admin.jsp , либо на user.jsp
     *
     */
    @GetMapping("/afterlogin")
    public ModelAndView afterlogin(){
        ModelAndView modelAndView = new ModelAndView();
        String userlogin = getCurrentUsername();

        GlobalUser globalUser = detailedService.getGlobalUser(userlogin);

         if(globalUser == null) {
             throw new RuntimeException("Method afterlogin: Not found user by login :" + userlogin);
         }
         String str = (String) globalUser.getUserRole();
         if(str.equalsIgnoreCase("ADMIN")){
                modelAndView.setViewName("admin.jsp");
         }else{
                modelAndView.setViewName("user.jsp");
         }
        return modelAndView;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }



    /**
     * метод accountUserForm обрабатывает GET запрос от браузера с мэппингом /add
     * по добавлению нового вклада клиента, используя форму registration_old.jsp
     *
     */
    @GetMapping("/add")
    public ModelAndView accountUserForm(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration.jsp");
        modelAndView.addObject("todaydata", new Date().toString());
        return modelAndView;
    }


    /**
     * метод accountUserPost обрабатывает POST запроса с мэппингом /add
     * извлекает из переданной формы registration_old.jsp данные
     * добавляет пользователя в БД и извещает о выполненной транзакции
     *
     */
    @PostMapping("/add")
    public ModelAndView addUserPost(
            @RequestParam("userlogin") String userlogin ,
            @RequestParam("password") String password ,
            @RequestParam("firstname") String firstname ,
            @RequestParam("middlename") String middlename ,
            @RequestParam("lastname") String lastname ,
            @RequestParam("birthday") String birthday ,
            @RequestParam("passport") String passport ,
            @RequestParam("passportorg") String passportorg ,
            @RequestParam("passportdate") String passportdate ,
            @RequestParam("email") String email ,
            @RequestParam("telephone") String telephone
    ){
        ModelAndView modelAndView = new ModelAndView();
        GlobalUser globalUserFromDB= detailedService.getGlobalUser(userlogin);
        if( !userlogin.equals("")
                && !birthday.equals("")
                && !passportdate.equals("")
                && globalUserFromDB == null) {
            Clients clients = new Clients();
            clients.setUserLogin(userlogin);
            clients.setFirstName(firstname);
            clients.setMiddleName(middlename);
            clients.setLastName(lastname);

            LocalDate date = LocalDate.parse(birthday);
            java.sql.Date sqlDate=  java.sql.Date.valueOf(date);
            clients.setBirthday(sqlDate);

            clients.setPassport(passport);
            clients.setPassportOrg(passportorg);

            LocalDate datePass = LocalDate.parse(passportdate);
            java.sql.Date sqlDatePass=  java.sql.Date.valueOf(datePass);
            clients.setPassportDate(sqlDatePass);

            clients.setEmail(email);
            clients.setPhone(telephone);

            detailedService.saveUserData(clients);

            GlobalUser globalUser = new GlobalUser();
            globalUser.setUserLogin(userlogin);
            globalUser.setUserPassword(password);
            globalUser.setUserRole(UserRoleType.User);
            detailedService.saveGlobalData(globalUser);

            modelAndView.setViewName("/add_user_success.jsp");
        }else{
            if(globalUserFromDB!=null){
                modelAndView.addObject("userlogin", userlogin);
                modelAndView.addObject("message", " уже существует.");
            }else{
                modelAndView.addObject("userlogin", userlogin);
                modelAndView.addObject("message", " не может бфть добавлен.");
            }
            modelAndView.setViewName("/fail_add_user.jsp");
        }
        return modelAndView;
    }
}
