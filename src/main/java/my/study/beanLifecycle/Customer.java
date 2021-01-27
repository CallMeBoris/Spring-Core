package my.study.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Customer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private String firstName;

    public Customer() {
        System.out.println("Customer non-arg constructor...");
    }

    public Customer(String firstName) {
        System.out.println("Customer First Name constructor... "+firstName);
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("setFirstName... "+firstName);
        this.firstName = firstName;
    }

    public void setBeanName(String s) {
        System.out.println("setBeanName... "+s);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory... "+beanFactory.isSingleton("cust"));
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext... "+applicationContext.isPrototype("cust"));
        this.firstName = "Boris in Application Context";
    }
}
