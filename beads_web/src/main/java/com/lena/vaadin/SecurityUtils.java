package com.lena.vaadin;

import com.lena.configuration.Constant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Collection;

/**
 * Created by alexey.dranchuk on 15/1/15.
 */
public class SecurityUtils {


    public static boolean userHasAdminRole() {
        return hasRole(Constant.ROLE_ADMIN);
    }

    @SuppressWarnings("unchecked")
    private static boolean hasRole(String roleAdmin) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        Collection<SimpleGrantedAuthority> authorities = (Collection < SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (SimpleGrantedAuthority authority : authorities) {
            if (roleAdmin.equals(authority.getAuthority())) {
                return true;
            }
        }
        return false;
    }
}
