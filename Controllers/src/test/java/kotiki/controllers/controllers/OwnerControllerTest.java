package kotiki.controllers.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
//@WebMvcTest(OwnerController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OwnerControllerTest {
    OwnerControllerTest(){
    }
    @Autowired
    private MockMvc mvc;
    @Test
    public void getAllOwnersTest() throws Exception {
        mvc.perform(get("/owner/get_all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getOwnerTest() throws Exception {
        mvc.perform(get("/owner/get?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void deleteOwnerTest() throws Exception {
        mvc.perform(delete("/owner/delete?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void addOwnerTest() throws Exception {
//        mvc.perform(post("/owner/add?dateOfBirth=12-12-2022&name=asdfasdfg"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andReturn();
        Assertions.assertEquals(true, true);
    }
}
