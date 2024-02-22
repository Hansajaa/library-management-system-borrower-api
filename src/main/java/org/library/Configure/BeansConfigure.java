package org.library.Configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeansConfigure {

    @Bean
    ModelMapper setUp(){
        return new ModelMapper();
    }
}
