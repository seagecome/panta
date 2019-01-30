package com.wanwu.panta.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wanwu.panta.biz.PantaRoleService;
import com.wanwu.panta.biz.PantaUserService;
import com.wanwu.panta.common.dto.SecurityWrapperUser;
import com.wanwu.panta.dal.domain.PantaRole;
import com.wanwu.panta.dal.domain.PantaUser;

@Service
public class PantaUserDetailsService implements UserDetailsService {

	@Autowired
	private PantaUserService pantaUserService;
	@Autowired
	private PantaRoleService pantaRoleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		PantaUser pantaUser = pantaUserService.queryPantaUserByName(username);
		
		if(pantaUser == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		
		List<PantaRole> roleList = pantaRoleService.queryPantaRolesByUserId(pantaUser.getId());
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		if(roleList == null) {
			return new SecurityWrapperUser(username, pantaUser.getPassword(), authorities);
		}
		
		for(PantaRole pr : roleList) {
			authorities.add(new SimpleGrantedAuthority(pr.getRoleName()));
		}
		
		String password = new BCryptPasswordEncoder().encode(pantaUser.getPassword());
		
		return new SecurityWrapperUser(username, password, authorities);
	}

}
