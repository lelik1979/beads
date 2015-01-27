package com.lena.service.velocity;

import com.lena.configuration.EmailConfiguration;
import com.lena.configuration.HibernateConfigurationTest;
import com.lena.domain.Order;
import com.lena.domain.Product;
import com.lena.service.job.EmailServiceConfigurationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={HibernateConfigurationTest.class, EmailServiceConfigurationTest.class, EmailConfiguration.class})
public class EmailGeneratorTest {

    @Autowired
    private EmailGenerator emailGenerator;
    
    @Test
    public void testMessageGeneration() {
        Order order = buildOrder();
        String emailBody = emailGenerator.getEmailBody(order);
    }

    private Order buildOrder() {
        Order order = new Order();
        order.setId(12);
        order.setPhoneNumber("0980813068");
        order.setProducts(buildProducts());
        return order;
    }

    private List<Product> buildProducts() {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("product1");
        p1.setPrice(BigDecimal.valueOf(11.22));
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("product2");
        p2.setPrice(BigDecimal.valueOf(33.22));
        return Arrays.asList(p1, p2);
    }

}