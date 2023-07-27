package org.example;

import com.example.secondspring.service.SecondServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class FirstAppInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry =  applicationContext.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SecondServiceImpl.class);
        registry.registerSingleton("SecondService", new SecondServiceImpl());
        //registry.registerBeanDefinition("SecondService", beanDefinition);
    }
}
