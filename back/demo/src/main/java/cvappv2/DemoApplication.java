package cvappv2;

import cvappv2.data.CvRepository;
import cvappv2.data.CvUserRepository;
import cvappv2.entity.Cv;
import cvappv2.entity.CvUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

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
            CvUser user = new CvUser(1L, "furkan", "pass", cv1);
            userRepo.save(user);
            CvUser user2 = new CvUser(2L, "tolga", "pass", cv2);
            userRepo.save(user2);
            CvUser admin = new CvUser(3L, "admin", "pass", null);
            userRepo.save(admin);
        };
    }
}
