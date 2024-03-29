package org.library.Service;

import org.library.Dto.LoginDto;

public interface LoginService {

    void saveEmailAndPassword(LoginDto dto);

    Boolean existsByEmailAndPassword(LoginDto dto);
}
