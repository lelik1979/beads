package com.beads.email.dao;

import java.util.List;

/**
 * Created by alexey.dranchuk on 24/1/15.
 *
 */

public interface OrderDao extends com.beads.model.dao.OrderDao {

    public List<Integer> loadPendingOrderIds();

}
