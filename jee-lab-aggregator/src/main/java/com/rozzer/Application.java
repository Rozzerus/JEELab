package com.rozzer;

import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.ManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SuppressWarnings("SpringFacetCodeInspection")
@SpringBootApplication
//@EnableJpaRepositories("com.rozzer.spring.repositories")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    public void init(ManagerFactory managerFactory){
        if (CoreObjectManager.getInstance().getManagerFactory() == null) {
            CoreObjectManager.getInstance().setManagerFactory(managerFactory);
        }
    }

}
