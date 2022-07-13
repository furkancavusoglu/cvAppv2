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
    @Autowired
    CvUserRepository cvUserRepository;

    public CvUserService(CvUserRepository cvUserRepository) {
        this.cvUserRepository = cvUserRepository;
    }

    public CvUser getUserByUsername(String username) {
        return this.cvUserRepository.findCvUserByUsername(username).orElse(null);
    }

}
