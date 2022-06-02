package dabao.beanloader.anotation;


import dabao.beanloader.spring.register.SpiRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Import(SpiRegister.class)
public @interface EnableSpi {

    String[] basePackages() default {};
}
