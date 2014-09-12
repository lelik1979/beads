package com.lena.webcontroller.dataprovider;

import com.lena.domain.Razdel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12.09.14.
 */
public class WebControllerDataProvider {

    public static List<Razdel> buildRazdels() {
        List<Razdel> razdels = new ArrayList<Razdel>();
        razdels.add(new Razdel(1, "perviy"));
        razdels.add(new Razdel(2, "vtoroy"));
        return razdels;
    }
}
