package dabao.beanloader.autoconfigure;


import dabao.beanloader.factory.SpiAutowiredBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpiAutowiredAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    SpiAutowiredBeanFactoryPostProcessor spiAutowiredBeanFactoryPostProcessor(){
        return new SpiAutowiredBeanFactoryPostProcessor();
    }
}
