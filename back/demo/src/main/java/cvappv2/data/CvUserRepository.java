package cvappv2.data;

import cvappv2.entity.CvUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CvUserRepository extends CrudRepository<CvUser, Long> {

    Optional<CvUser> findCvUserByUsername(String username);

}
