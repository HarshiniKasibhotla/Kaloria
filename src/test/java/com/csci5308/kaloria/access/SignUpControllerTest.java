package com.csci5308.kaloria.access;
// package com.csci5308.kaloria.accessControl;

// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.verifyNoMoreInteractions;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.RequestBuilder;
// import org.springframework.test.web.servlet.ResultActions;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import com.csci5308.kaloria.registration.SignUpController;

// @RunWith(SpringJUnit4ClassRunner.class)
// @WebMvcTest(SignUpController.class)
// public class SignUpControllerTest {


// 	@MockBean
// 	private transient User user;
	
// 	@Autowired
// 	private transient MockMvc mockMvc;

// 	@Before
// 	public void setUp() {
		
// 	}

// 	@Test
// 	public void testRegisterUser() throws Exception {
// 		doNothing().when(user).createUser(user,"Password@123");
// 		mockMvc.perform((RequestBuilder) ((ResultActions) post("/register")).andExpect(view().name("login")));
// 		verify(user, times(1)).createUser(Mockito.any(User.class), Mockito.anyString());
// 		verifyNoMoreInteractions(user);
// 	}

// }
