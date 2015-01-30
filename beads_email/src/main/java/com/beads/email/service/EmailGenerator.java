package com.beads.email.service;

import com.beads.model.domain.Order;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexey.dranchuk on 29/1/15.
 *
 */

@Service
public class EmailGenerator {

    public static final Logger LOG = LoggerFactory.getLogger(EmailGenerator.class);

    @Autowired
    private VelocityEngine velocityEngine;

    public String getEmailBody(Order order) {
        Map<String, Object> model = new HashMap<>();
        model.put("order", order);
        return VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "email/manager.email.vm", "UTF-8", model);
    }

}
