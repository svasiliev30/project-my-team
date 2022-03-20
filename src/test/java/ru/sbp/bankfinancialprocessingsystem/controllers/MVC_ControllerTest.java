package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.config.ServerConfig;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
class MVC_ControllerTest {
    @Test
    void test_clients() {

        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        MVC_Controller mvc_controller = context.getBean(MVC_Controller.class);
        Assert.assertTrue(Objects.nonNull(mvc_controller.clients()));

        ModelAndView modelAndView1= mvc_controller.clients();
        Assert.assertTrue(modelAndView1.getViewName().equals("/clients.jsp"));
    }

    @Test
    void test_delete() {

        Clients client = new Clients("Optimus Prime", "Ole", "fdsg",
                "sdf", Date.valueOf("2000-01-01"), "45566", "sdfhg",
                Date.valueOf("2000-01-01"), "sgsdgfh", "778455468");
        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        MVC_Controller mvc_controller = context.getBean(MVC_Controller.class);
        Assert.assertTrue(Objects.nonNull(mvc_controller.new_user(client)));
        ModelAndView modelAndView1= mvc_controller.delete("Optimus Prime");
        Assert.assertTrue(modelAndView1.getViewName().equals("/clients.jsp"));
        Assert.assertTrue(modelAndView1.getModel().get("message").equals("Пользователь с логином 'Optimus Prime' удален и клиент с логином 'Optimus Prime' удален!"));
    }
    @Test
    void test_getAll() {

        Clients client = new Clients("Optimus Prime", "Ole", "fdsg",
                "sdf", Date.valueOf("2000-01-01"), "45566", "sdfhg",
                Date.valueOf("2000-01-01"), "sgsdgfh", "778455468");
        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        MVC_Controller mvc_controller = context.getBean(MVC_Controller.class);
        Assert.assertTrue(Objects.nonNull(mvc_controller.new_user(client)));
        ModelAndView modelAndView1= mvc_controller.getAll();

        Assert.assertTrue(modelAndView1.getViewName().equals("/all.jsp"));
        Assert.assertTrue(modelAndView1.getModel().get("message").equals("Сводный список всех клиентов банка:"));
        Assert.assertTrue(((List)modelAndView1.getModel().get("clientsList1")).size() > 0);
        Assert.assertTrue(Objects.nonNull(mvc_controller.delete("Optimus Prime")));
    }

    @Test
    void test_new_user() {

        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        Clients client = new Clients("Optimus Prime", "Ole", "fdsg",
                "sdf", Date.valueOf("2000-01-01"), "45566", "sdfhg",
                Date.valueOf("2000-01-01"), "sgsdgfh", "778455468");
        MVC_Controller mvc_controller = context.getBean(MVC_Controller.class);
        ModelAndView modelAndView2 = mvc_controller.new_user(client);
        Assert.assertTrue(modelAndView2.getViewName().equals("/clients.jsp"));
        Assert.assertTrue(modelAndView2.getModel().get("message").equals("Новый клиент внесен!"));
        ModelAndView modelAndView = mvc_controller.new_user(client);
        Assert.assertTrue(modelAndView.getModel().get("message").equals("Изменения внесены успешно!"));
        Assert.assertTrue(modelAndView.getModel().get("userData").equals(client));
        client.setUserLogin("");
        ModelAndView modelAndView1 = mvc_controller.new_user(client);
        Assert.assertTrue(modelAndView1.getViewName().equals("/clients.jsp"));
        Assert.assertTrue(modelAndView1.getModel().get("message").equals("Нельзя зписывать клиента с пустым логином!"));
        Assert.assertTrue(Objects.nonNull(mvc_controller.delete("Optimus Prime")));
    }
    @Test
    void test_find_fio() {

        ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        Clients client = new Clients("Optimus Prime", "Optimus", "Robos",
                "Prime", Date.valueOf("2000-01-01"), "45566", "sdfhg",
                Date.valueOf("2000-01-01"), "sgsdgfh", "778455468");
        MVC_Controller mvc_controller = context.getBean(MVC_Controller.class);
        ModelAndView modelAndView = mvc_controller.new_user(client);

        ModelAndView modelAndView1 = mvc_controller.find_fio("Optimus", "Prime", "Robos");
        Assert.assertTrue(modelAndView1.getModel().get("userData") != null);
        ModelAndView modelAndView2 = mvc_controller.find_fio("", "Prime", "");
        Assert.assertTrue(modelAndView2.getModel().get("userData") != null);
        ModelAndView modelAndView3 = mvc_controller.find_fio("Optimus", "", "");
        Assert.assertTrue(modelAndView3.getModel().get("userData") != null);

        ModelAndView modelAndView4 = mvc_controller.find_fio("Optimus1", "Prime2", "Robos3");
        Assert.assertTrue(modelAndView4.getModel().get("userData") == null);

        Assert.assertTrue(Objects.nonNull(mvc_controller.delete("Optimus Prime")));
    }
}