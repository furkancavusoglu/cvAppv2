package cvappv2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String school;
    private String skills;
    private String experiences;

}
