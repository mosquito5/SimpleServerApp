package pl.jakub.moskal.SimpleServerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakub.moskal.SimpleServerApp.model.UserInfo;

public interface UseInfoRepository extends JpaRepository<UserInfo, Long> {
}
