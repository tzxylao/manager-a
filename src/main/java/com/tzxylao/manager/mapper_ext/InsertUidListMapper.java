package com.tzxylao.manager.mapper_ext;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

public interface InsertUidListMapper<T> {
    @Options(useGeneratedKeys = false, keyProperty = "json_id")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);
}