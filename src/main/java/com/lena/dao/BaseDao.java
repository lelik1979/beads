package com.lena.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 10.09.14.
 */
@Repository
@Transactional
public class BaseDao {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource
    private Map<QueryKey, String> sqls;

    public String getSql(QueryKey key) {
        String sql = sqls.get(key);
        if (StringUtils.isEmpty(sql))
            throw new IllegalArgumentException("There is no query with key " + key);
        return sql.trim();
    }

}
