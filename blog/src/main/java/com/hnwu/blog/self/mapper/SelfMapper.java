package com.hnwu.blog.self.mapper;

import com.hnwu.blog.self.entity.SelfInfo;
import org.springframework.stereotype.Repository;

/**
 * Mybatis
 * Created by 吴会楠 on 2017/12/19.
 */
@Repository
public interface SelfMapper {

    SelfInfo getSelf(Integer id);
}
