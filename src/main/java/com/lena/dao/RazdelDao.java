package com.lena.dao;

import com.lena.domain.Razdel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 25.08.14.
 */
@Repository
public class RazdelDao extends BaseDao {

    public static final Logger LOG = LoggerFactory.getLogger(RazdelDao.class);

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    public void init() {
        LOG.debug("started");
    }

    public List<Razdel> loadAllSections() {
        String sql = getSql(QueryKey.LOAD_ALL_SECTIONS);
        return namedTemplate.getJdbcOperations().query(sql, new RowMapper<Razdel>() {
            @Override
            public Razdel mapRow(ResultSet rs, int rowNum) throws SQLException {
                Razdel razdel = new Razdel(rs.getInt("ID"), rs.getString("NAME"));
                razdel.setParentId(rs.getInt("parent_id"));
                return razdel;
            }
        });
    }
}
