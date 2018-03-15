package com.hnwu.blog.self.dao;

import com.hnwu.blog.self.entity.SelfInfo;

import java.util.List;

/**
 * Created by 吴会楠 on 2017/12/7.
 */
public interface SelfInfoDao {
    int save(SelfInfo selfInfo);

    SelfInfo queryByName(String username);

    List<SelfInfo> query();

    int updateSelf(SelfInfo selfInfo);
}
