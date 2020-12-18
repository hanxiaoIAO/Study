package study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
//@Import(MyService.class)
//@Import(MyClass.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public class StartAppliaction {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(StartAppliaction.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }
}
