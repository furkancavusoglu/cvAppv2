package cvappv2.controller;

import cvappv2.entity.CvUser;
import cvappv2.data.CvUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminPageController {
    CvUserRepository userRepo;

    public AdminPageController(CvUserRepository userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping
    public Iterable<CvUser> getAllUsers(){
        return userRepo.findAll();
    }
}
