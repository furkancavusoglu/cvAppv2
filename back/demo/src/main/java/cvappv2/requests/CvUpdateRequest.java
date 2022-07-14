package cvappv2.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvUpdateRequest {

    private String name;
    private String email;
    private String phoneNumber;
    private String school;
    private String skills;
    private String experiences;
}
