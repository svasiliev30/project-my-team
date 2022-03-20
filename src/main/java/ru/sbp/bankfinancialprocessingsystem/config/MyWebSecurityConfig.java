package ru.sbp.bankfinancialprocessingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @author Filin RKonstantin
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
//
                .disable()
                .authorizeRequests()
                //Доступ разрешен всем пользователей
                .antMatchers("/").permitAll()
                //Доступ только для не зарегистрированных пользователей
                //.antMatchers("/add").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin").hasRole("Admin")
                .antMatchers("/add").hasRole("Admin")
                .antMatchers("/delete").hasRole("Admin")
                //Доступ только для пользователей с ролью User
                .antMatchers("/user").hasRole("User")
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
               // .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/afterlogin")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
          return NoOpPasswordEncoder.getInstance();
    }
}
