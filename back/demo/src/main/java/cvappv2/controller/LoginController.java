package cvappv2.controller;

import cvappv2.entity.CvUser;
import cvappv2.requests.CvUserAuthRequest;
import cvappv2.service.CvUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    CvUserService cvUserService;

    public LoginController(CvUserService cvUserService) {
        this.cvUserService = cvUserService;
    }

    @PostMapping
    public ResponseEntity<?> authorize(@RequestBody CvUserAuthRequest request) {
        return cvUserService.authorize(request);
    }

}
