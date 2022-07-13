package cvappv2.controller;


import cvappv2.entity.Cv;
import cvappv2.service.CvService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CvFormController {
    CvService cvService;

    public CvFormController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("{username}")
    public ResponseEntity<Cv> getUserCv(@PathVariable String username) {
       return cvService.getUserCv(username);
    }

    @PutMapping("{username}")
    public ResponseEntity<String> postCv(@RequestBody Cv cv, @PathVariable String username) {
       return cvService.postCv(cv,username);
    }
}
