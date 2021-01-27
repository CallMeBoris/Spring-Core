package my.study.beanLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-lifecycle.xml");
        String firstName = context.getBean("cust",Customer.class).getFirstName();
        System.out.println("First name: "+firstName);
    }
}
