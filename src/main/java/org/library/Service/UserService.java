package org.library.Service;

import org.library.Dto.UserDto;
import org.library.Entity.UserEntity;

import java.util.List;

public interface UserService {

    boolean addUser(UserDto dto);

    List<UserEntity> getUsers();

    boolean deleteUser(Long id);
}
