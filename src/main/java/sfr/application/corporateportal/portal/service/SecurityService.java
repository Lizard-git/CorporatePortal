package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import sfr.application.corporateportal.portal.dto.CastomUserDetails;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.RoleRepository;
import sfr.application.corporateportal.portal.repository.UserRepository;

import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    //private final JwtService jwtService;

    @Override
    @Transactional(value = "portalTransactionManager")
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsersEntity user = findByUserLogin(login);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException(String.format(" User '%s' not found", login));
        }
        return new CastomUserDetails(user);
    }

    public UsersEntity findByUserLogin(String login) {
        try {
            return userRepository.findByLogin(login).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void save(UsersEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
