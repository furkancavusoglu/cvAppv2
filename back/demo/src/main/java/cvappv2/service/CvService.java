package cvappv2.service;

import cvappv2.data.CvUserRepository;
import cvappv2.entity.Cv;
import cvappv2.entity.CvUser;
import cvappv2.data.CvRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvService {

    private CvRepository cvRepository;
    private CvUserRepository cvUserRepository;

    CvService(CvRepository cvRepository, CvUserRepository cvUserRepository) {
        this.cvUserRepository = cvUserRepository;
        this.cvRepository = cvRepository;
    }


    public ResponseEntity<Cv> getUserCv(String username) {
        Optional<CvUser> user = cvUserRepository.findCvUserByUsername(username);
        if (user.isPresent()) {
            CvUser cvUser = user.get();
            return new ResponseEntity<>(cvUser.getUserCv(), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<String> postCv(Cv cv, String username) {
       CvUser user = cvUserRepository.findCvUserByUsername(username).get();
       user.setUserCv(cv);
       return ResponseEntity.ok("Cv updated");
    }
}
