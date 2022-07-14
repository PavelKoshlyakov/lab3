package kotiki.controllers.controllers;

import kotiki.controllers.controllers.CatController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
//@WebMvcTest(CatController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatControllerTest {
    CatControllerTest(){
    }
    @Autowired
    private MockMvc mvc;
//    @MockBean
//    private CatController catController;
    @Test
    public void getAllCatsTest() throws Exception {
        mvc.perform(get("/cat/get_all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getCatTest() throws Exception {
        mvc.perform(get("/cat/get?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getCatByBreedTest() throws Exception {
        mvc.perform(get("/cat/get_by_breed?breed=asdfgh"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void deleteCatTest() throws Exception {
        mvc.perform(delete("/cat/delete?id=10"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getAllFriendsOfCatByIdTest() throws Exception {
        mvc.perform(get("/cat/find_friends?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }
    @Test
    public void updateCatTest() throws Exception {
        mvc.perform(post("/cat/update?id=1&name=asdf"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

    }
    @Test
    public void addCatTest() throws Exception {
        mvc.perform(post("/cat/add?name=as&dateOfBirth=12-12-2022&breed=qwerty&colour=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
