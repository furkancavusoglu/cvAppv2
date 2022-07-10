package cvappv2.responses;

import cvappv2.entity.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvUserAuthResponse {

    private String username;

    private String password;
}
