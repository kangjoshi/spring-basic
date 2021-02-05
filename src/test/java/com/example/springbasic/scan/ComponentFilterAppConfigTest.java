package com.example.springbasic.scan;

import com.example.springbasic.scan.filter.BeanA;
import com.example.springbasic.scan.filter.BeanB;
import com.example.springbasic.scan.filter.MyExcludeComponent;
import com.example.springbasic.scan.filter.MyIncludeComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = applicationContext.getBean(BeanA.class);

        Assertions.assertEquals(beanA.getClass(), BeanA.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            BeanB beanB = applicationContext.getBean(BeanB.class);
        });
    }

    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }


}
