package cvappv2.service;

import cvappv2.data.CvUserRepository;
import cvappv2.entity.Cv;
import cvappv2.entity.CvUser;
import cvappv2.requests.CvUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvService {
    private CvUserRepository cvUserRepository;

    CvService(CvUserRepository cvUserRepository) {
        this.cvUserRepository = cvUserRepository;
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

    public ResponseEntity<String> postCv(CvUpdateRequest cv, String username) {
        CvUser user = cvUserRepository.findCvUserByUsername(username).get();
        user.getUserCv().setName(cv.getName());
        user.getUserCv().setPhoneNumber(cv.getPhoneNumber());
        user.getUserCv().setSkills(cv.getSkills());
        user.getUserCv().setSchool(cv.getSchool());
        user.getUserCv().setExperiences(cv.getExperiences());
        user.getUserCv().setEmail(cv.getEmail());
        cvUserRepository.save(user);
        return ResponseEntity.ok("Cv updated");
    }
}
