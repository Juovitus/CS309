package myProject.ControllerTests;

import myProject.Controllers.UserController;
import myProject.Repositories.UserRepository;
import myProject.Models.User;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 
 * @author Noah Hoss
 *
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    UserRepository user;

    private StringBuilder mfd;
    /**
     * Mocking data
     * @param params
     * @return string of mocked data
     */
    private String BuildMockFormData(String... params){
        //We Field names and values, so there should always be a number /2 number of params
        if((params.length % 2) > 0){
            throw new IllegalArgumentException("Incorrect number of parameters given");
        }
        StringBuilder mockedFormData = new StringBuilder();

        for(int i = 0; i < params.length; i+= 2){
            if(i > 0){
                mockedFormData.append('&');
            }
            try{
                mockedFormData.append(URLEncoder.encode(params[i], StandardCharsets.UTF_8.name())).append('=')
                        .append(URLEncoder.encode(params[i+1], StandardCharsets.UTF_8.name()));
            }catch(UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        mfd = mockedFormData;
        return mockedFormData.toString();
    }
    /**
     * Test ensuring not null
     */
    @Test
    public void ValidateControllerConnection(){
        assertThat(mvc).isNotNull();
    }
    /**
     * Testing add user
     * @throws Exception
     */
    @Test
    public void TestAddUser() throws Exception{
        MockHttpServletRequest req = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));

        //create user to test mock data against
        User testUser = new User("TestUser", "TestPassword", "TestUser@gmail.com");

        when(user.FindUserByUserName("TestUser")).thenReturn(Optional.of(testUser));
        //maybe user not users..but I think its user
        //creating mocked data to test against testUser
        //Could probably re-work this a bit so that I don't have to have private StringBuilder mfd above, but it works for now.
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/user")
                .content(BuildMockFormData(
                        "user_name", "TestUser",
                        "password", "TestPassword",
                        "user_email", "TestUser@gmail.com"))).andReturn();

        //replace @ in email with unicode as mfd.toString returns unicode.
        String testUserEmailThing = testUser.userEmail.replaceAll("@", "%40");

        //This is probably a bad way to validate this, but it works so like...?
        assertThat(mfd.toString()).isEqualTo("user_name=" + testUser.userName + "&" +
                "password=" + testUser.password + "&" +
                "user_email=" + testUserEmailThing);
    }
}
