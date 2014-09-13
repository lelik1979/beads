package com.lena.webcontroller;

import com.lena.restservice.RestWebService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RestWebServiceTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RestWebService restWebService;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(restWebService).build();
//        when(razdelService.loadSections()).thenReturn(WebControllerDataProvider.buildRazdels());
    }

    @Test
    public void checkResponse() throws Exception {
        mockMvc.perform(get("/rest1"))
                .andDo(print())
                .andExpect(content().string("id="));
    }
}