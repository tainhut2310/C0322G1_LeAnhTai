package com.codegym.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    int count = 0;

    @Pointcut("execution(* com.codegym.controller.BookController.update(..))")
    public void lendBookPointCut() {
    }

    @AfterReturning("lendBookPointCut()")
    public void lendBookLog() {
        System.out.println("1 người dùng mượn sách thành công, lúc " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.controller.BookController.payBook(..))")
    public void payBookPointCut() {
    }

    @AfterReturning("payBookPointCut()")
    public void payBookLog() {
        System.out.println("1 người dùng trả sách thành công, lúc " + LocalDateTime.now());
    }

    @Pointcut("within(com.codegym.controller.*)")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void writeAllAction() {
        count++;
        System.out.println("Tính đến lúc: " + LocalDateTime.now() + ", có tất cả: " + count + " thao tác với thư viện");
    }
}
