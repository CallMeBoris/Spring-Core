package my.study.destruction;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class Customer implements DisposableBean {

    public void destroy() throws Exception {
        System.out.println("DisposableBean: destroy...");
    }

    @PreDestroy
    public void customDestroy(){
        System.out.println("customDestroy...");
    }
}
