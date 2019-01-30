package com.wanwu.panta.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.wanwu.panta.biz.PantaRoleService;
import com.wanwu.panta.dal.domain.PantaRole;

@Service
public class PantaFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private PantaRoleService pantaRoleService;
	
	Map<String, Collection<ConfigAttribute>> map = null;
	private void loadResourceData(String accessUrl) {
		List<PantaRole> roleList = pantaRoleService.queryPantaRolesByUrl(accessUrl);
		if(roleList == null || roleList.size() == 0) {
			return;
		}
		
		Collection<ConfigAttribute> caArray = new ArrayList<ConfigAttribute>();
		for(PantaRole pr : roleList) {
			ConfigAttribute ca = new SecurityConfig(pr.getRoleName());
			caArray.add(ca);
		}
		map.put(accessUrl, caArray);
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
		String accessUrl = request.getServletPath();
		if(map == null) {
			map = new HashMap<>();
			loadResourceData(accessUrl);
		}
		if(map.get(accessUrl) == null) {
			loadResourceData(accessUrl);
		}
		return map.get(accessUrl);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
