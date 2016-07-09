package com.may.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
/**
 * Created by mayxys on 2016/7/7.
 * http://zhaozhiming.github.io/blog/2014/06/16/spring-mvc-unit-test-part-1/
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@WebAppConfiguration()
public class YcProjectReleaseControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @InjectMocks
    private YcProjectReleaseController ycProjectReleaseController;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void fileList() throws Exception {
        mockMvc.perform(get("/releasePersonListPage?pageNum=1&pageSize=10")).andDo(print()).andExpect(status().isOk());
                //.andExpect(content().string(is("{\"status\":\""  + "\"}")));
    }
}
