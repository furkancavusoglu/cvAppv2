package cvappv2;

import cvappv2.data.CvRepository;
import cvappv2.data.CvUserRepository;
import cvappv2.entity.Cv;
import cvappv2.entity.CvUser;
import cvappv2.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class DemoApplication {
    @Autowired
    PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(CvUserRepository userRepo, CvRepository cvRepo) {
        return args -> {
            Cv cv1 = new Cv(5L, "furkan c", "cfurkannn@gmail.com",
                    "5312227847", "Estu", "Java", "Yok");
            Cv cv2 = new Cv(4L, "Tolga", "tolga@gmail.com",
                    "5312227847", "Estu", "Java", "Yok");
            CvUser user = new CvUser(1L, "furkan", encoder.encode("pass"),
                    cv1, new Role(null, "ROLE_USER"));
            userRepo.save(user);
            CvUser user2 = new CvUser(2L, "tolga", encoder.encode("pass"),
                    cv2, new Role(null, "ROLE_USER"));
            userRepo.save(user2);
            CvUser admin = new CvUser(3L, "admin", encoder.encode("pass"),
                    null, new Role(null, "ROLE_ADMIN"));
            userRepo.save(admin);
        };
    }
}
