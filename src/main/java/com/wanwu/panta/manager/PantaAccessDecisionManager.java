package com.wanwu.panta.manager;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class PantaAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if(configAttributes == null || configAttributes.size() <= 0) {
			return;
		}
		
		if(authentication == null || authentication.getAuthorities() == null || authentication.getAuthorities().size() <= 0) {
			return;
		}
		String needRole = null;
		for(ConfigAttribute ca : configAttributes) {
			needRole = ca.getAttribute();
			for(GrantedAuthority ga : authentication.getAuthorities()) {
				if(ga.getAuthority().equals(needRole.trim())) {
					return;
				}
			}
		}
		throw new AccessDeniedException("no access right");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
