package com.tzxylao.manager.mapper;


import com.tzxylao.manager.entity.Trole;
import com.tzxylao.manager.utils.MyMapper;

import java.util.List;

public interface TroleMapper extends MyMapper<Trole> {

    List<Trole> selectRolesByUserId(Integer userid);

}