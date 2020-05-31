package pl.jakub.moskal.SimpleServerApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakub.moskal.SimpleServerApp.model.UserInfo;
import pl.jakub.moskal.SimpleServerApp.repository.UseInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UseInfoRepository useInfoRepository;

    private final ValidationService validationService;

    @Override
    public boolean saveNote(UserInfo userInfo) {
        try {
            if(validationService.validatePhoneNumber(userInfo.getPhone())) {
                useInfoRepository.save(userInfo);
                return true;
            }
            return false;

        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return useInfoRepository.findById(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return useInfoRepository.findAll();
    }
}
