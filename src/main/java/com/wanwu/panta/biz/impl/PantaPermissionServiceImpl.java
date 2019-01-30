package com.wanwu.panta.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanwu.panta.biz.PantaPermissionService;
import com.wanwu.panta.dal.domain.PantaPermission;
import com.wanwu.panta.dal.domain.PantaPermissionExample;
import com.wanwu.panta.dal.mapper.PantaPermissionMapper;

@Service
public class PantaPermissionServiceImpl implements PantaPermissionService {

	@Autowired
	private PantaPermissionMapper pantaPermissionMapper;
	
	@Override
	public List<PantaPermission> queryPermissionById(int userId) {
		return pantaPermissionMapper.selectPermissionById(userId);
	}

	@Override
	public List<PantaPermission> queryAllPermission() {
		PantaPermissionExample example = new PantaPermissionExample();
		return pantaPermissionMapper.selectByExample(example);
	}

}
