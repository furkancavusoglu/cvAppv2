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
import org.springframework.security.crypto.password.PasswordEncoder;

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
            Cv cv1 = new Cv(null, "furkan c", "cfurkannn@gmail.com",
                    "5312227847", "Estu", "Java", "Yok");
            Cv cv2 = new Cv(null, "Tolga", "tolga@gmail.com",
                    "5312227847", "Estu", "Java", "Yok");
            CvUser user = new CvUser(null, "furkan", encoder.encode("pass"),
                    cv1, new Role(null, "ROLE_USER"));
            userRepo.save(user);
            CvUser user2 = new CvUser(null, "tolga", encoder.encode("pass"),
                    cv2, new Role(null, "ROLE_USER"));
            userRepo.save(user2);
            CvUser admin = new CvUser(null, "admin", encoder.encode("pass"),
                    null, new Role(null, "ROLE_ADMIN"));
            userRepo.save(admin);
        };
    }
}
