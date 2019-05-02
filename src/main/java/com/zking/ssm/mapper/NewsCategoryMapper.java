package com.zking.ssm.mapper;

import com.zking.ssm.model.NewsCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);
}