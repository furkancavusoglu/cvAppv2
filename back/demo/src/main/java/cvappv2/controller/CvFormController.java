package cvappv2.controller;


import cvappv2.Cv;
import cvappv2.CvUser;
import cvappv2.data.CvUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class CvFormController {
    CvUserRepository userRepo;

    CvUser cvUser;

    public CvFormController(CvUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("{username}")
    public ResponseEntity<Cv> getUserCv(@PathVariable String username) {
        Optional<CvUser> user = userRepo.findCvUserByUsername(username);
        if (user.isPresent()) {
            cvUser = user.get();
            return new ResponseEntity<>(user.get().getUserCv(), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public HttpStatus postCv(@RequestBody Cv cv) {
        cvUser.setUserCv(cv);
        userRepo.save(cvUser);
        return HttpStatus.OK;
    }


}
