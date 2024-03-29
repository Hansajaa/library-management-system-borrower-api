package org.library.Configure;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BeansConfigure {

    @Bean
    ModelMapper setUp(){
        return new ModelMapper();
    }

    @Bean
    StrongPasswordEncryptor set(){
        return new StrongPasswordEncryptor();
    }
}
