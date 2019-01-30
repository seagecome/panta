package com.wanwu.panta.biz;

import java.util.List;

import com.wanwu.panta.dal.domain.PantaPermission;

public interface PantaPermissionService {
	List<PantaPermission> queryPermissionById(int userId);
	List<PantaPermission> queryAllPermission();
}
