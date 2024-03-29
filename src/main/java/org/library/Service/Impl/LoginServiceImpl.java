package org.library.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.library.Dto.LoginDto;
import org.library.Entity.LoginEntity;
import org.library.Repository.LoginRepository;
import org.library.Service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoginServiceImpl implements LoginService {

    final LoginRepository repository;
    final ModelMapper mapper;

    final StrongPasswordEncryptor encryptor;

    @Override
    public void saveEmailAndPassword(LoginDto dto) {
        LoginEntity entity = mapper.map(dto, LoginEntity.class);
        entity.setPassword(encryptor.encryptPassword(dto.getPassword()));

        repository.save(entity);
    }
}
