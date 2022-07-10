package cvappv2.service;

import cvappv2.data.CvUserRepository;
import cvappv2.entity.CvUser;
import cvappv2.entity.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    CvUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CvUser> getUser = repo.findCvUserByUsername(username);
        if (getUser.isPresent()) {
            CvUser user = getUser.get();
            return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), user.getUserCv());
        } else throw new UsernameNotFoundException("Username not found");
    }
}
