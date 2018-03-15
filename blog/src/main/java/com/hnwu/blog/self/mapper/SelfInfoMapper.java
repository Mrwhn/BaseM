package com.hnwu.blog.self.mapper;

import com.hnwu.blog.self.entity.SelfInfo;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 吴会楠 on 2017/12/19.
 */
public interface SelfInfoMapper {
    @Select("select * from t_user where id=#{id}")
    SelfInfo getSelfInfo(Integer id);

}
