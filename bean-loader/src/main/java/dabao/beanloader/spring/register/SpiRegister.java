package dabao.beanloader.spring.register;


import cn.hutool.core.map.MapUtil;
import dabao.beanloader.anotation.EnableSpi;
import dabao.beanloader.anotation.Spi;
import dabao.beanloader.factory.SpiFactory;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class SpiRegister implements ImportBeanDefinitionRegistrar,BeanFactoryAware {


    private DefaultListableBeanFactory beanFactory;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registerSingleton(importingClassMetadata);

    }

    private void registerSingleton(AnnotationMetadata importingClassMetadata) {
        Set<Class<?>> spiInterfaces = getSpiInterface(importingClassMetadata);
        if(!spiInterfaces.isEmpty()){
            for (Class<?> spiInterface : spiInterfaces) {
                Map<String,?> spiMap = new SpiFactory().getSpiMap(spiInterface);
                if(MapUtil.isNotEmpty(spiMap)){
                    spiMap.forEach((beanName,bean) -> {
                        registerSpiInterfaceSingleton(spiInterface, bean);
                        beanFactory.registerSingleton(beanName,bean);
                    });
                }
            }
        }
    }

    private void registerSpiInterfaceSingleton(Class<?> spiInterface, Object bean) {
        Spi spi = spiInterface.getAnnotation(Spi.class);
        String defaultSpiImplClassName = spi.defalutSpiImplClassName();
        if(StringUtils.isBlank(defaultSpiImplClassName)){
            defaultSpiImplClassName = spi.value();
        }

        String beanName = bean.getClass().getName();
        if(beanName.equals(defaultSpiImplClassName)){
            String spiInterfaceBeanName = StringUtils.uncapitalize(spiInterface.getSimpleName());
            beanFactory.registerSingleton(spiInterfaceBeanName,bean);
        }
    }

    private Set<Class<?>> getSpiInterface(AnnotationMetadata importingClassMetadata) {
        List<String> basePackages = getBasePackages(importingClassMetadata);
        Set<Class<?>> spiClassSet = new HashSet<>();
        for (String basePackage : basePackages) {
            Reflections reflections = new Reflections(basePackage);
            Set<Class<?>> spiClasses = reflections.getTypesAnnotatedWith(Spi.class);
            if(!CollectionUtils.isEmpty(spiClasses)){
                for (Class<?> spiClass : spiClasses) {
                    if(spiClass.isInterface()){
                        spiClassSet.add(spiClass);
                    }
                }
            }
        }

        return spiClassSet;
    }

    private List<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> enableSpi = importingClassMetadata.getAnnotationAttributes(EnableSpi.class.getName());
        String[] spiBasePackages = (String[]) enableSpi.get("basePackages");
        List<String> basePackages =  Arrays.asList(spiBasePackages);
        if(CollectionUtils.isEmpty(basePackages)){
            basePackages = new ArrayList<>();
            basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory)beanFactory;
    }
}

