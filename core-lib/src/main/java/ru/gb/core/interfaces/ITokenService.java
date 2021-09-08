package ru.gb.core.interfaces;

import ru.gb.core.models.UserInfo;

public interface ITokenService {

    String generateToken(UserInfo user);

    UserInfo parseToken(String token);
}
