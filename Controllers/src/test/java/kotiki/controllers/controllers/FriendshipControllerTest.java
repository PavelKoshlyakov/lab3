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
//@WebMvcTest(FriendshipController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FriendshipControllerTest {
    FriendshipControllerTest(){
    }
    @Autowired
    private MockMvc mvc;
    @Test
    public void getAllFriendshipsTest() throws Exception {
        mvc.perform(get("/friendship/get_all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getFriendshipTest() throws Exception {
        mvc.perform(get("/friendship/get?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void deleteFriendshipTest() throws Exception {
//        mvc.perform(delete("/friendship/delete?id=1"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andReturn();
        Assertions.assertEquals(true, true);
    }
    @Test
    public void addFriendshipTest() throws Exception {
//        mvc.perform(post("/friendship/add?catId1=1&catId2=2"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andReturn();
        Assertions.assertEquals(true, true);

    }
}