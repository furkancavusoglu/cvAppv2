package cvappv2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl create(CvUser user) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add( new SimpleGrantedAuthority(user.getRole().getRole()));
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(),authorityList);
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
