package sfr.application.corporateportal.portal.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import sfr.application.corporateportal.portal.entity.RolesEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class CastomUserDetails implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;

    private String login;

    private String password;

    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

    private Boolean isEnabled;

    private Boolean deleted;

    public CastomUserDetails(UsersEntity user) {
        this.login = user.getLogin();
        this.password=user.getPassword();
        this.authorities= mapRoleToAuthorities(user.getRoles());
        this.isAccountNonExpired = user.getIsAccountNonExpired();
        this.isAccountNonLocked = user.getIsAccountNonLocked();
        this.isCredentialsNonExpired = user.getIsCredentialsNonExpired();
        this.isEnabled = user.getIsEnabled();
        this.deleted = ObjectUtils.isEmpty(user.getDeleteDate());
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<RolesEntity> role) {
        return role.stream()
                .map(RolesEntity::getAuthority)
                .flatMap(Collection::stream)
                .map(it -> new SimpleGrantedAuthority(it.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.deleted;
    }
}
