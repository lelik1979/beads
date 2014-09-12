package com.lena.dao;

import com.lena.domain.Razdel;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class RazdelDaoTest extends BaseDaoTest {

    @Autowired
    private RazdelDao razdelDao;


    @Test
    public void testLoadAllSections() throws Exception {
        List<Razdel> allrazdels = razdelDao.loadAllSections();
    }
}