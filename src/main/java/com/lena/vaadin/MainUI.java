package com.lena.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.xpoft.vaadin.DiscoveryNavigator;

/**
 * Created by alexey.dranchuk on 23/12/14.
 */

@Component("MainUI")
@Scope("prototype")
@Theme("reindeer")
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();

        new DiscoveryNavigator(this, this);

    }


}
