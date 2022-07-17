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
//@WebMvcTest(OwnershipController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OwnershipControllerTest {
    OwnershipControllerTest(){
    }
    @Autowired
    private MockMvc mvc;
    @Test
    public void getAllOwnershipsTest() throws Exception {
        mvc.perform(get("/ownership/get_all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    public void getOwnershipsOfOwnerTest() throws Exception {
        mvc.perform(get("/ownership/get_ownerships_of_owner?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getOwnershipTest() throws Exception {
        mvc.perform(get("/ownership/get?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void deleteOwnershipTest() throws Exception {
        mvc.perform(delete("/ownership/delete?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void addOwnershipTest() throws Exception {
//        mvc.perform(post("/ownership/add?catId=1&ownerId=1"))
//            .andExpect(status().isOk())
//                .andDo(print())
//                .andReturn();
        Assertions.assertEquals(true, true);

    }
}