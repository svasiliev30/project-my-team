package ru.sbp.bankfinancialprocessingsystem.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Класс ServerLoggerAspect содержит методы сквозного логирования
 * @version 1.0
 * @autor Sergey Vasiliev
 *
 */
@Component
@Aspect
public class ServerLoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServerLoggerAspect.class);

    /**
     * Метод logPointcut
     */
    @Pointcut("within(ru.sbp.bankfinancialprocessingsystem.BankFinancialProcessingSystemApplication)")
    public void logPointcut() {
    }

    /**
     * Метод startLog выполняет сквозное логирование перед началом выполнения метода
     *
     * @param - JoinPoint
     */
    @Before("logPointcut()")
    public void startLog(JoinPoint joinPoint) {
        logger.info("Start run service " + joinPoint.getSignature().getName() + " " + LocalDateTime.now());
    }

    /**
     * Метод endLog выполняет сквозное логирование после окончания выполнения метода
     *
     * @param - JoinPoint
     */
    @After("logPointcut()")
    public void endLog(JoinPoint joinPoint) {
        logger.info("End run service " + joinPoint.getSignature().getName() + " " + LocalDateTime.now());
    }

}
