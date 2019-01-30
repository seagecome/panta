package com.wanwu.panta.dal.mapper;

import com.wanwu.panta.dal.domain.PantaPermission;
import com.wanwu.panta.dal.domain.PantaPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PantaPermissionMapper {
    long countByExample(PantaPermissionExample example);

    int deleteByExample(PantaPermissionExample example);

    int insert(PantaPermission record);

    int insertSelective(PantaPermission record);

    List<PantaPermission> selectByExample(PantaPermissionExample example);

    int updateByExampleSelective(@Param("record") PantaPermission record, @Param("example") PantaPermissionExample example);

    int updateByExample(@Param("record") PantaPermission record, @Param("example") PantaPermissionExample example);
    
    List<PantaPermission> selectPermissionById(int userId);
}