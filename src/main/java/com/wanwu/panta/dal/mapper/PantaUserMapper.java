package com.wanwu.panta.dal.mapper;

import com.wanwu.panta.dal.domain.PantaUser;
import com.wanwu.panta.dal.domain.PantaUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PantaUserMapper {
    long countByExample(PantaUserExample example);

    int deleteByExample(PantaUserExample example);

    int insert(PantaUser record);

    int insertSelective(PantaUser record);

    List<PantaUser> selectByExample(PantaUserExample example);

    int updateByExampleSelective(@Param("record") PantaUser record, @Param("example") PantaUserExample example);

    int updateByExample(@Param("record") PantaUser record, @Param("example") PantaUserExample example);
}