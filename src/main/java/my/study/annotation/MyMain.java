package my.study.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        SMSService smsService = (SMSService) context.getBean("smsService");
        smsService.sendMessage("Boris","Hi");
    }
}
