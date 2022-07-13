package cvappv2.controller;

import cvappv2.requests.CvUserAuthRequest;
import cvappv2.responses.CvUserAuthResponse;
import cvappv2.security.JwtUtil;
import cvappv2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<CvUserAuthResponse> authorize(@RequestBody CvUserAuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            System.out.println("Bad Credentials :" + e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<>(
                new CvUserAuthResponse(request.getUsername(),userDetails.getAuthorities().toString(),token), HttpStatus.OK);
    }

}

