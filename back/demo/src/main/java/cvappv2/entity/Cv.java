package cvappv2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
    @Id
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String school;
    private String skills;
    private String experiences;

}
