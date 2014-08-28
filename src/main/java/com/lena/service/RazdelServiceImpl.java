package com.lena.service;

import com.lena.domain.Razdel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 25.08.14.
 */
@Service
public class RazdelServiceImpl implements RazdelService {

    private static List<Razdel> razdels;

    static {
        razdels = Arrays.asList(new Razdel(1, "razdel1"), new Razdel(2, "razdel2"));
    }

    @Override
    public List<Razdel> findAllRazdels() {
        return razdels;
    }
}
