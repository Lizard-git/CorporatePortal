package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import sfr.application.corporateportal.portal.dto.CastomUserDetails;
import sfr.application.corporateportal.portal.entity.AuthorityEntity;
import sfr.application.corporateportal.portal.entity.RolesEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.AuthorityRepository;
import sfr.application.corporateportal.portal.repository.RoleRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class SecurityService implements UserDetailsService {
    private final UsersService usersService;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    /**
     * Загружает пользователя по его login для осуществления авторизации
     * @param login the username identifying the user whose data is required.
     * @return UserDetails, для Spring Security
     * @throws UsernameNotFoundException - Ошибка ! Пользователь с таким Login не найден
     */
    @Override
    @Transactional(value = "portalTransactionManager")
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsersEntity user = usersService.findByUserLogin(login);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException(String.format(" User '%s' not found", login));
        }
        return new CastomUserDetails(user);
    }

    /**
     * Получаем все роли в системе
     * @return List<RolesEntity>
     */
    public List<RolesEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Получаем все права доступа в системе
     * @return List<RolesEntity>
     */
    public List<AuthorityEntity> getAllAuthority() {
        return authorityRepository.findAll();
    }
}
