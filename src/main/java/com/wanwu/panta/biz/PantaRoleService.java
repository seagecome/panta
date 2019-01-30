package com.wanwu.panta.biz;

import java.util.List;

import com.wanwu.panta.dal.domain.PantaRole;

public interface PantaRoleService {
	PantaRole queryPantaRoleById(int roleId);
	List<PantaRole> queryAllPantaRoles();
	List<PantaRole> queryPantaRolesByUrl(String permissionUrl);
	
	List<PantaRole> queryPantaRolesByUserId(int userId);
}
