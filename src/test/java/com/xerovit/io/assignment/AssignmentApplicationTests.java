package com.xerovit.io.assignment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.xerovit.io.assignment.util.ServerUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {
	@Value("${test.url}")
	String url;
	private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIwOTk3Mjc4NDY2MCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU1ODY0MjA2NSwidXNlciI6eyJwYXNzd29yZCI6bnVsbCwidXNlcm5hbWUiOiIwOTk3Mjc4NDY2MCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJhY2NvdW50Tm9uRXhwaXJlZCI6dHJ1ZSwiYWNjb3VudE5vbkxvY2tlZCI6dHJ1ZSwiY3JlZGVudGlhbHNOb25FeHBpcmVkIjp0cnVlLCJlbmFibGVkIjp0cnVlLCJ1c2VySWQiOjJ9LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6IjRjZWFlNDE4LWE5ZTQtNDVkMS1hMjY3LTk3Yzk2YTU1YTYwMiIsImNsaWVudF9pZCI6ImNsaWVudCJ9.APa_qb0d55w-krdQnM3e-XbJFi-XuNs9x4InfF2q9ko";

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setup() {
		ServerUtil.IS_DEV = true;
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void save() throws Exception {
		mockMvc.perform(post(url + "user/").contentType("application/json;charset=UTF-8").header("Authorization", "Bearer "+token).content(
				"{\"userId\":\"2\",\"username\":\"zinminwai\",\"password\":\"$2a$10$hYG93u7Ghkn7VpKQRJ9JAeH3FNhuwLmrmuov4w6aMnY5h/EYSY5ga\",\"email\":\"zinminwai@gmail.com\",\"telephone\":\"+959972784663\"}"))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void getData() throws Exception {
		mockMvc.perform(get(url + "user/1").contentType("application/json;charset=UTF-8").header("Authorization", "Bearer "+token)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void getAll() throws Exception {
		mockMvc.perform(get(url + "user/").contentType("application/json;charset=UTF-8").header("Authorization", "Bearer "+token)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
}
