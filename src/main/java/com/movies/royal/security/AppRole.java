package com.movies.royal.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.movies.royal.security.AppPermission.*;

@Getter
@RequiredArgsConstructor
public enum AppRole {
    GUEST(Sets.newHashSet(DATA_READ)),
    ADMIN(Sets.newHashSet(DATA_READ,DATA_WRITE));

    private final Set<AppPermission> permissionSet;

    public Set<SimpleGrantedAuthority> getGrantedAuthoritySet(){
        return getPermissionSet().stream()
                .map(appPermission -> new SimpleGrantedAuthority(appPermission.getPermissionInfo()))
                .collect(Collectors.toSet());
    }
}
