package com.wanwu.panta.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanwu.panta.biz.PantaRoleService;
import com.wanwu.panta.dal.domain.PantaRole;
import com.wanwu.panta.dal.domain.PantaRoleExample;
import com.wanwu.panta.dal.mapper.PantaRoleMapper;

@Service
public class PantaRoleServiceImpl implements PantaRoleService {

	@Autowired
	private PantaRoleMapper pantaRoleMapper;
	
	@Override
	public PantaRole queryPantaRoleById(int roleId) {
		PantaRoleExample example = new PantaRoleExample();
		example.createCriteria().andIdEqualTo(roleId);
		List<PantaRole> roleList = pantaRoleMapper.selectByExample(example);
		if(roleList == null || roleList.size() == 0) {
			return null;
		}
		return roleList.get(0);
	}

	@Override
	public List<PantaRole> queryAllPantaRoles() {
		PantaRoleExample example = new PantaRoleExample();
		return pantaRoleMapper.selectByExample(example);
	}

	@Override
	public List<PantaRole> queryPantaRolesByUrl(String permissionUrl) {
		return pantaRoleMapper.queryPantaRolesByUrl(permissionUrl);
	}

	@Override
	public List<PantaRole> queryPantaRolesByUserId(int userId) {
		return pantaRoleMapper.queryPantaRolesByUserId(userId);
	}

}
