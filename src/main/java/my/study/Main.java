package my.study;

import my.study.config.AppConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        //EmailService emailService = new EmailService();
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService = context.getBean("emailService",EmailService.class);
        System.out.println(emailService);
        emailService.sendEmail("Boris","Hello");

        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService emailService1 = context1.getBean("emailService", EmailService.class);
        System.out.println(emailService1);
        emailService1.sendEmail("Boris2","Hello2");
    }
}
