package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.GlobalUser;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.UserRoleType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.GlobalUserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Сервлет контроллер, выводит страницу html по адресу "http://localhost:8080/clients/main"
 * обработка запросов от браузера
 * функции: работа с базой клиентов, БД postgres Hibernate
 * new_user() регистрация нового клиента, изменение данных клиента (один метод на оба сценария)
 * getAll() вывод всех клиентов из БД на страницу jsp
 * clients() поиск по логину
 * find_fio() поиск по ФИО
 * delete() удаление по логину
 * поле логина userLogin это id БД
 * исключения выкидыват Hibernate
 */
@Controller
@RequestMapping(value = "/clients")
public class MVC_Controller {

    private ClientsRepository clientsRepository;
    private GlobalUserRepository globalUserRepository;

    @Autowired
    public void setClientsRepository(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @Autowired
    public void setGlobalUserRepository(GlobalUserRepository globalUserRepository) {
        this.globalUserRepository = globalUserRepository;
    }

    /**
     * основной вход, возвращает jsp с несколькими столбцами, первый пуст,
     * втрой и третий части интерфейса работы с клиентом
     * @return возврат модели на страницу jsp
     */
    @GetMapping("/main")
    public ModelAndView clients(){

        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        model.addObject("message", "Добро пожаловать в систему поиска и регитрации клиентов банка!");
        return model;
    }

    /**
     * удаление клиента по логину, так же удаляется запись из таблицы global_user
     * @param userLogin логин клиента
     * @return возврат модели на страницу jsp
     */
    @PostMapping("/main")
    public ModelAndView delete(@RequestParam("userLogin") String userLogin){

        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");

        Optional<Clients> client = clientsRepository.findById(userLogin);
        Optional<GlobalUser> globalUser = globalUserRepository.findById(userLogin);
        String message;

        if (!globalUser.isPresent())
        {
            message = "Пользователь с логином '" + userLogin + "' не найден в базе данных и ";
        } else {
            globalUserRepository.deleteById(userLogin);
            message = "Пользователь с логином '" + userLogin + "' удален и ";
        }

        if (!client.isPresent())
        {
            model.addObject("message", message + "клиент с логином '" + userLogin + "' не найден в базе данных!");
        } else {
            clientsRepository.deleteById(userLogin);
            model.addObject("message", message + "клиент с логином '" + userLogin + "' удален!");
        }

        return model;
    }

    /**
     * поиск клиента по логину
     * @param userLogin логин клиента
     * @return возврат модели на страницу jsp
     */
    @GetMapping("/find")
    public ModelAndView clients(@RequestParam("userLogin") String userLogin){

        Optional<Clients> client = clientsRepository.findById(userLogin);
        ModelAndView model = new ModelAndView();
        model.setViewName("/clients.jsp");
        if (!client.isPresent())
        {
            model.addObject("message", "Клиент с логином '" + userLogin + "' не найден в базе данных!");
        } else {
            model.addObject("userData",client.get());
            model.addObject("message", "Добро пожаловать в систему поиска и регитрации клиентов банка!");
        }
        return model;
    }

    /**
     * выводит всех клиентов на отдельную jsp страницу
     * @return возврат модели на страницу jsp
     */
    @GetMapping("/all")
    public ModelAndView getAll() {

        ModelAndView model = new ModelAndView();
        model.setViewName("/all.jsp");
        int i = 0;
        Collection<Clients> clients1 = new ArrayList<>(); Collection<Clients> clients2 = new ArrayList<>();
        for (Clients clientsIterator: this.clientsRepository.findAll()) {
            if (i++%2==0)
            {
                clients1.add(clientsIterator);
            } else {
                clients2.add(clientsIterator);
            }
        }

        model.addObject("message", "Сводный список всех клиентов банка:");
        model.addObject("clientsList1", clients1);
        model.addObject("clientsList2", clients2);
        return model;
    }

    /**
     * создать учетнцю запись клиента/изменить данные клиета
     * создает запись в таблице global_user
     * @param client объект с данными клиета со страницы
     * @return возврат модели на страницу jsp
     */
    @PostMapping("/create")
    public ModelAndView new_user(@RequestBody() Clients client){

        ModelAndView model = new ModelAndView();
        if (client == null || client.getUserLogin().equals("")) {
            model.addObject("message", "Нельзя зписывать клиента с пустым логином!");
        } else {
            if (clientsRepository.findById(client.getUserLogin()).isPresent()) {

                model.addObject("message", "Изменения внесены успешно!");
            } else {

                model.addObject("message", "Новый клиент внесен!");
            }
            System.out.printf(clientsRepository.save(client).toString());
            globalUserRepository.save(new GlobalUser(client.getUserLogin(), "123456", "User"));

            model.addObject("userData", client);
        }
        model.setViewName("/clients.jsp");
        return model;
    }

    /**
     * поиск клиента по ФИО
     * @param firstName имя клиента
     * @param secondName фамилия клиента
     * @param middleName отчество клиента
     * @return возврат модели на страницу jsp
     */
    @GetMapping("/find_fio")
    public ModelAndView find_fio(@RequestParam("firstName") String firstName,
                                 @RequestParam("secondName") String secondName,
                                 @RequestParam("middleName") String  middleName) {

        ModelAndView model = new ModelAndView();
        if (firstName.equals("")&&secondName.equals("")&&middleName.equals("")) {
            model.addObject("message", "Поиск пустых данных закончится неудачей!");
        } else {
            List<Clients> clientsList = new ArrayList<>();
            for (Clients usr: clientsRepository.findAll()) {
                if ((!firstName.equals("")?usr.getFirstName().equals(firstName):true)
                        && (!secondName.equals("")?usr.getLastName().equals(secondName):true)
                        && (!middleName.equals("")?usr.getMiddleName().equals(middleName):true))
                {
                    clientsList.add(usr);
                }
            }
            if (clientsList.size() == 0){
                model.addObject("message", "Клиентов с данным фио не найдено в базе данных!");
            } else if (clientsList.size() > 1){
                model.addObject("message", "Клиентов с данным фио найдено больше одного!");
            } else {
                model.addObject("message", "Найден один пользователь!");
                model.addObject("userData", clientsList.get(0));
            }
        }
        model.setViewName("/clients.jsp");
        return model;
    }
}
