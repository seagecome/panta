package com.wanwu.panta.biz;

import com.wanwu.panta.dal.domain.PantaUser;

public interface PantaUserService {
	PantaUser queryPantaUserById(int id);
	PantaUser queryPantaUserByName(String username);
}
