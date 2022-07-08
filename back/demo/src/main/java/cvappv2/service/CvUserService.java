package cvappv2.service;

import cvappv2.entity.CvUser;
import cvappv2.data.CvUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvUserService {
    CvUserRepository cvUserRepository;

    public CvUserService(CvUserRepository cvUserRepository){
        this.cvUserRepository = cvUserRepository;
    }

    public ResponseEntity<?> authorize(CvUser user) {
        Optional<CvUser> data = cvUserRepository.findCvUserByUsername(user.getUsername());
        if (data.isPresent() && data.get().getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }
}
