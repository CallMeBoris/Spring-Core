package my.study.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("cust")
public class Customer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

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

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
        this.firstName = "Boris in after properties set";
    }

    @PostConstruct
    public void customInit(){
        System.out.println("customInit...");
        this.firstName = "Boris in customInit";
    }
}
