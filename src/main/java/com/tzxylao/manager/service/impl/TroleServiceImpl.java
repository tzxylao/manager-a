package com.tzxylao.manager.service.impl;

import com.tzxylao.manager.entity.Trole;
import com.tzxylao.manager.mapper.TroleMapper;
import com.tzxylao.manager.service.TroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("troleService")
public class TroleServiceImpl extends BaseService<Trole> implements TroleService {
    @Autowired
    private TroleMapper troleMapper;

    @Override
    public List<Trole> selectRolesByUserId(Integer userid) {
        return troleMapper.selectRolesByUserId(userid);
    }
}
