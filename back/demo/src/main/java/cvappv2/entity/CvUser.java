package cvappv2.entity;



import cvappv2.entity.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CvUser {
    @Id
    private Long id;

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Cv userCv;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Role role;

}

