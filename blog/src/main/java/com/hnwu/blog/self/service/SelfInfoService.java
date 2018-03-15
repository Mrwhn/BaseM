package com.hnwu.blog.self.service;

import com.hnwu.blog.self.entity.SelfInfo;
import java.util.List;

/**
 * Created by 吴会楠 on 2017/12/7.
 */
public interface SelfInfoService {
    int saveSelf(SelfInfo selfInfo);
    SelfInfo queryByName(String username);
    List<SelfInfo> query();
    int updateSelf(SelfInfo selfInfo);

    /**
     * mybatis测试(无配置文件版)
     */
    SelfInfo getSelfInfo(Integer id);
    /**
     * mybatis测试(配置文件版)
     */
    SelfInfo getSelf(Integer id);
}
