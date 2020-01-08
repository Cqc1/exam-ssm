package ssm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.model.Admin;
import ssm.model.AdminExample;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);
    
    //自定义方法
    //验证管理员信息
    public Admin getAdmin(@Param("adid") int adid, @Param("adpwd") String adpwd);
    
    
   }