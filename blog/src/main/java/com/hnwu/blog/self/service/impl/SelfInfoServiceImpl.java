package com.hnwu.blog.self.service.impl;

import com.hnwu.blog.self.dao.SelfInfoDao;
import com.hnwu.blog.self.entity.SelfInfo;
import com.hnwu.blog.self.mapper.SelfInfoMapper;
import com.hnwu.blog.self.mapper.SelfMapper;
import com.hnwu.blog.self.service.SelfInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SelfInfo的Service层
 * Created by 吴会楠 on 2017/12/7.
 */
@Service
public class SelfInfoServiceImpl implements SelfInfoService {
    @Autowired
    private SelfInfoDao selfInfoDao;

    @Autowired
    private SelfInfoMapper selfInfoMapper;

    @Autowired
    private SelfMapper selfMapper;

    @Override
    public int saveSelf(SelfInfo selfInfo) {
        return selfInfoDao.save(selfInfo);
    }

    @Override
    public SelfInfo queryByName(String username) {
        return selfInfoDao.queryByName(username);
    }

    @Override
    public List<SelfInfo> query() {
        return selfInfoDao.query();
    }

    @Override
    public int updateSelf(SelfInfo selfInfo) {
        return selfInfoDao.updateSelf(selfInfo);
    }

    @Override
    public SelfInfo getSelfInfo(Integer id) {
        return selfInfoMapper.getSelfInfo(id);
    }

    @Override
    public SelfInfo getSelf(Integer id) {
        System.out.println("才测试恶意：即可打开是");
        return selfMapper.getSelf(id);
    }
}
