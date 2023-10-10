package cyberminds.backend.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import cyberminds.backend.BackendApplication;
import cyberminds.backend.dto.request.ForgotPasswordRequestDTO;
import cyberminds.backend.dto.request.LoginDTO;
import cyberminds.backend.dto.request.PasswordResetDTO;
import cyberminds.backend.dto.request.RegistrationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = BackendApplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class AppUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_createUserAccount_IsSuccess() throws Exception {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setFirstName("John");
        registrationDTO.setLastName("Doe");
        registrationDTO.setEmail("okoroaforkelechi123@gmail.com");
        registrationDTO.setPassword("StrongPassword123@");

        mockMvc.perform(MockMvcRequestBuilders.post("https://cyber-mind-deploy.onrender.com/api/users/create")
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registrationDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    public void test_userLogin_IsSuccess() throws Exception {
        LoginDTO loginRequest = new LoginDTO();
        loginRequest.setEmail("okoroaforkelechi123@gmail.com");
        loginRequest.setPassword("StrongPassword123@");

//        mockMvc.perform(MockMvcRequestBuilders.post("https://cyber-mind-deploy.onrender.com/api/users/login")
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void test_forgotPassword_IsSuccess() throws Exception {
        ForgotPasswordRequestDTO forgotPasswordRequest = new ForgotPasswordRequestDTO();
        forgotPasswordRequest.setEmail("okoroaforkelechi123@gmail.com");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/forgot-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(forgotPasswordRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void test_resetPassword_IsSuccess() throws Exception {
        PasswordResetDTO resetPasswordRequest = new PasswordResetDTO();
        resetPasswordRequest.setEmail("okoroaforkelechi123@gmail.com");
        resetPasswordRequest.setNewPassword("NewStrongPassword123@");
        resetPasswordRequest.setConfirmPassword("NewStrongPassword123@");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/reset-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(resetPasswordRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
