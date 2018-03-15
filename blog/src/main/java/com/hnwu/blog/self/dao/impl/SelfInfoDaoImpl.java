package com.hnwu.blog.self.dao.impl;

import com.hnwu.blog.self.dao.SelfInfoDao;
import com.hnwu.blog.self.entity.SelfInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 吴会楠 on 2017/12/7.
 */
@Repository
public class SelfInfoDaoImpl implements SelfInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(SelfInfo selfInfo){
        int result = 0;
        try{
            result = jdbcTemplate.update("insert into t_user(username,password) value (?,?)",selfInfo.getUsername(),selfInfo.getPassword());
        }catch (Exception e){
            e.printStackTrace();
            result = 2;
        }
        return result;
    }

    @Override
    public SelfInfo queryByName(String username) {
         List<SelfInfo> list = jdbcTemplate.query("select username,password from t_user t where t.username=?", new RowMapper<SelfInfo>() {
             @Override
             public SelfInfo mapRow(ResultSet rs, int i) throws SQLException {
                if(rs != null){
                    SelfInfo selfInfo = new SelfInfo();
                    selfInfo.setUsername(rs.getString("username"));
                    selfInfo.setPassword(rs.getString("password"));
                    return selfInfo;
                }else{
                    return null;
                }
             }
         }, username);
        return (list == null || list.size() == 0) ? null:list .get(0);
    }

    @Override
    public List<SelfInfo> query() {
        return jdbcTemplate.query("select username,password from t_user t ", new RowMapper<SelfInfo>() {
            @Override
            public SelfInfo mapRow(ResultSet rs, int i) throws SQLException {
                SelfInfo selfInfo = new SelfInfo();
                selfInfo.setUsername(rs.getString("username"));
                selfInfo.setPassword(rs.getString("password"));
                return selfInfo;
            }
        });
    }

    @Override
    public int updateSelf(SelfInfo selfInfo) {
        return jdbcTemplate.update("update t_user t set t.password=? where t.id=?", selfInfo.getPassword(), selfInfo.getId());
    }
}
