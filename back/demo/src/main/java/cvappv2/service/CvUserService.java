package cvappv2.service;

import cvappv2.entity.CvUser;
import cvappv2.data.CvUserRepository;
import cvappv2.entity.UserDetailsImpl;
import cvappv2.requests.CvUserAuthRequest;
import cvappv2.responses.CvUserAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CvUserService {
    @Autowired
    UserServiceImpl service;
    CvUserRepository cvUserRepository;

    public CvUserService(CvUserRepository cvUserRepository) {
        this.cvUserRepository = cvUserRepository;
    }

    public CvUser getUserByUsername(String username) {
        return this.cvUserRepository.findCvUserByUsername(username).orElse(null);
    }
//    public ResponseEntity<?> authorize(CvUser user) {
//        Optional<CvUser> data = cvUserRepository.findCvUserByUsername(user.getUsername());
//        if (data.isPresent() && data.get().getPassword().equals(user.getPassword())) {
//            return new ResponseEntity<>(data.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
//        }
//    }
    public ResponseEntity<?> authorize(CvUserAuthRequest request) {
        UserDetails userAuth;
        try {
            userAuth = service.loadUserByUsername(request.getUsername());
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("Bad Credentials", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new CvUserAuthResponse(userAuth.getUsername(),userAuth.getPassword()),HttpStatus.OK);
    }
}
