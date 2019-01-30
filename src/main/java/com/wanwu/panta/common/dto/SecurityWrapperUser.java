package com.wanwu.panta.common.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityWrapperUser extends User {
	private static final long serialVersionUID = -8651830334888079995L;

	public SecurityWrapperUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
}
