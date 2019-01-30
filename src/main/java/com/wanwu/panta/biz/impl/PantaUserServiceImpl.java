package com.wanwu.panta.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanwu.panta.biz.PantaUserService;
import com.wanwu.panta.dal.domain.PantaUser;
import com.wanwu.panta.dal.domain.PantaUserExample;
import com.wanwu.panta.dal.mapper.PantaUserMapper;

@Service("pantaUserService")
public class PantaUserServiceImpl implements PantaUserService {

	@Autowired
	private PantaUserMapper pantaUserMapper;
	
	@Override
	public PantaUser queryPantaUserByName(String username) {
		PantaUserExample example = new PantaUserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<PantaUser> list = pantaUserMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public PantaUser queryPantaUserById(int id) {
		PantaUserExample example = new PantaUserExample();
		example.createCriteria().andIdEqualTo(id);
		List<PantaUser> list = pantaUserMapper.selectByExample(example);
		return list.get(0);
	}

}
