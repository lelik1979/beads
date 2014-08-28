package com.lena.service;

import com.lena.domain.Razdel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 25.08.14.
 */

public interface RazdelService {

    List<Razdel> findAllRazdels();
}
