package com.funtl.hello.spring.cloud.zipkin;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * 名称: UniqueNameGenerator
 * 描述：解决bean冲突问题，定义自定义生成bean实现接口
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-28 20:16
 **/
public class UniqueNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry){
        //全限定类名
        String beanName = definition.getBeanClassName();
        return beanName;
    }
}
