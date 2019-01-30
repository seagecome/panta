package com.wanwu.panta.dal.mapper;

import com.wanwu.panta.dal.domain.PantaRole;
import com.wanwu.panta.dal.domain.PantaRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PantaRoleMapper {
    long countByExample(PantaRoleExample example);

    int deleteByExample(PantaRoleExample example);

    int insert(PantaRole record);

    int insertSelective(PantaRole record);

    List<PantaRole> selectByExample(PantaRoleExample example);

    int updateByExampleSelective(@Param("record") PantaRole record, @Param("example") PantaRoleExample example);

    int updateByExample(@Param("record") PantaRole record, @Param("example") PantaRoleExample example);
    
    List<PantaRole> queryPantaRolesByUrl(@Param("permissionUrl") String permissionUrl);
    
    List<PantaRole> queryPantaRolesByUserId(@Param("userId") int userId);
}