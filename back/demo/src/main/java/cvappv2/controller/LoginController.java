package cvappv2.controller;

import cvappv2.entity.CvUser;
import cvappv2.service.CvUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    CvUserService cvUserService;

    public LoginController(CvUserService cvUserService) {
        this.cvUserService = cvUserService;
    }

    @PostMapping
    public ResponseEntity<?> authorize(@RequestBody CvUser user) {
        return cvUserService.authorize(user);
    }

}
