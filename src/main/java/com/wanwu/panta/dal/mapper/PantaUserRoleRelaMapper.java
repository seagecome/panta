package com.wanwu.panta.dal.mapper;

import com.wanwu.panta.dal.domain.PantaUserRoleRela;
import com.wanwu.panta.dal.domain.PantaUserRoleRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PantaUserRoleRelaMapper {
    long countByExample(PantaUserRoleRelaExample example);

    int deleteByExample(PantaUserRoleRelaExample example);

    int insert(PantaUserRoleRela record);

    int insertSelective(PantaUserRoleRela record);

    List<PantaUserRoleRela> selectByExample(PantaUserRoleRelaExample example);

    int updateByExampleSelective(@Param("record") PantaUserRoleRela record, @Param("example") PantaUserRoleRelaExample example);

    int updateByExample(@Param("record") PantaUserRoleRela record, @Param("example") PantaUserRoleRelaExample example);
}