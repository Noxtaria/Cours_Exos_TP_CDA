package org.example.config;

import com.example.infrastructurespringdata.repository.impl.ReportRepositoryImpl;
import org.example.service.ReportServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ApiRestInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;
    public ApiRestInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("ReportService", new ReportServiceImpl(infraContext.getBean(ReportRepositoryImpl.class)));
    }
}
