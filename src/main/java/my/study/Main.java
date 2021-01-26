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
        EmailService emailService1 = context.getBean("emailService",EmailService.class);
        System.out.println("EmailService 1: "+emailService1);
       // emailService.sendEmail("Boris","Hello");

        ApplicationContext context2 = new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService2 = context2.getBean("emailService",EmailService.class);
        System.out.println("EmailService 2: "+emailService2);


        EmailService emailService3 =context.getBean("prototypeEmailService", EmailService.class);
        EmailService emailService4 =context.getBean("prototypeEmailService", EmailService.class);
        System.out.println("EmailService 3: "+emailService3);
        System.out.println("EmailService 4: "+emailService4);



        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService eService1 = context1.getBean("emailService", EmailService.class);
        System.out.println("eService 1: "+eService1);
        EmailService eService2 = context1.getBean("emailService", EmailService.class);
        System.out.println("eService 2: "+eService2);
        emailService1.sendEmail("Boris2","Hello2");

        EmailService eService3 = context1.getBean("prototypeEmailService", EmailService.class);
        System.out.println("eService 3: "+eService3);
        EmailService eService4 = context1.getBean("prototypeEmailService", EmailService.class);
        System.out.println("eService 3: "+eService4);
    }
}
