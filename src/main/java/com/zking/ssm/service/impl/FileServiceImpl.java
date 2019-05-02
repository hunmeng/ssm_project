package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.FileMapper;
import com.zking.ssm.model.File;
import com.zking.ssm.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileServiceImpl implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public int deleteByPrimaryKey(String fileId) {
        return 0;
    }

    @Override
    public int insert(File record) {
        return fileMapper.insert(record);
    }

    @Override
    public int insertSelective(File record) {
        return 0;
    }

    @Override
    public File selectByPrimaryKey(String fileId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(File record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(File record) {
        return 0;
    }
}
