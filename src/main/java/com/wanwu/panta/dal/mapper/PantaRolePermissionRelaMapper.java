package com.wanwu.panta.dal.mapper;

import com.wanwu.panta.dal.domain.PantaRolePermissionRela;
import com.wanwu.panta.dal.domain.PantaRolePermissionRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PantaRolePermissionRelaMapper {
    long countByExample(PantaRolePermissionRelaExample example);

    int deleteByExample(PantaRolePermissionRelaExample example);

    int insert(PantaRolePermissionRela record);

    int insertSelective(PantaRolePermissionRela record);

    List<PantaRolePermissionRela> selectByExample(PantaRolePermissionRelaExample example);

    int updateByExampleSelective(@Param("record") PantaRolePermissionRela record, @Param("example") PantaRolePermissionRelaExample example);

    int updateByExample(@Param("record") PantaRolePermissionRela record, @Param("example") PantaRolePermissionRelaExample example);
}