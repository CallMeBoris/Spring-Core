package my.study.javaConfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Customer {

    public Customer(){
        System.out.println("Default Constructor...");
    }

    @PostConstruct
    public void customInit(){
        System.out.println("customInit...");
    }

    @PreDestroy
    public void customDestroy(){
        System.out.println("customDestroy...");
    }
}