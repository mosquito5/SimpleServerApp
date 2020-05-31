package pl.jakub.moskal.SimpleServerApp.service;

import pl.jakub.moskal.SimpleServerApp.model.UserInfo;

import java.util.List;
import java.util.Optional;

public interface UserInfoService {

    boolean saveNote(UserInfo userInfo);

    Optional<UserInfo> findById(Long id);

    List<UserInfo> findAll();

}
