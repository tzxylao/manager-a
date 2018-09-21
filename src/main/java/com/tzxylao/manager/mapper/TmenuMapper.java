package com.tzxylao.manager.mapper;


import com.tzxylao.manager.entity.Tmenu;
import com.tzxylao.manager.utils.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface TmenuMapper extends MyMapper<Tmenu> {

    List<Tmenu> selectMenusByRoleId(Integer roleid);

    List<Tmenu> selectByParentIdAndRoleId(HashMap<String, Object> paraMap);

}