package com.lena.service;

import com.lena.dao.RazdelDao;
import com.lena.domain.Razdel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 25.08.14.
 */
@Service
@Transactional
public class RazdelServiceImpl implements RazdelService {

    private RazdelDao razdelDao;

    @Override
    public List<Razdel> loadSections() {
        return razdelDao.loadAllSections();
    }

    @Autowired
    public void setRazdelDao(RazdelDao razdelDao) {
        this.razdelDao = razdelDao;
    }
}
