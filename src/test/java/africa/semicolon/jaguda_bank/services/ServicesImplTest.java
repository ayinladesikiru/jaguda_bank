package africa.semicolon.jaguda_bank.services;

import africa.semicolon.jaguda_bank.data.RequestDto.DepositDto;
import africa.semicolon.jaguda_bank.data.RequestDto.LoginDto;
import africa.semicolon.jaguda_bank.data.RequestDto.RegisterUserDto;
import africa.semicolon.jaguda_bank.data.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServicesImplTest {
//    private UserRepository userRepository;
//    @BeforeEach
//    public void setup(){
//        userRepository.deleteAll();
//    }

    @Autowired
    private Services services;
    @Test
    public void testThatAccountCanBeCreated(){
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setName("Sikiru Ayinla");
        registerUserDto.setPhoneNumber("08056368236");
        registerUserDto.setEmail("sikiru@yahoo.com");
        registerUserDto.setPassword("1234");

//        String response = services.createAccount(registerUserDto);
//        assertEquals("Account created", response);
        assertThrows(IllegalArgumentException.class, ()-> services.createAccount(registerUserDto));


    }
    @Test
    public void testThatUserCanLogin(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("sikiru@yahoo.com");
        loginDto.setPassword("1234");

        String response = services.loginToAccount(loginDto);
        assertEquals("User logged in", response);
    }

    @Test
    public void  testThatUserCanDeposit(){
        DepositDto depositDto = new DepositDto();
        depositDto.setAccountNumber("3513638206");
        depositDto.setAmount(50000.00);

        Double response = services.deposit(depositDto);
        assertEquals(150000, response);
    }

}