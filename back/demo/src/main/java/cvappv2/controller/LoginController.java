package cvappv2.controller;

import cvappv2.CvUser;
import cvappv2.data.CvUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    CvUserRepository userRepo;

    public LoginController(CvUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity<?> authorize(@RequestBody CvUser user) {
        Optional<CvUser> data = userRepo.findCvUserByUsername(user.getUsername());
        if (data.isPresent() && data.get().getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().body(user.getUsername() + " " + user.getPassword());
        }
    }

}
