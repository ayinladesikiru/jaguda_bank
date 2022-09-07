package africa.semicolon.jaguda_bank.services;

import africa.semicolon.jaguda_bank.data.RequestDto.DepositDto;
import africa.semicolon.jaguda_bank.data.RequestDto.LoginDto;
import africa.semicolon.jaguda_bank.data.RequestDto.RegisterUserDto;
import africa.semicolon.jaguda_bank.data.model.User;
import africa.semicolon.jaguda_bank.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
@Service
public class ServicesImpl implements Services{
    @Autowired
    private UserRepository userRepository;
    @Override
    public String createAccount(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setName(registerUserDto.getName());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        user.setPhoneNumber(registerUserDto.getPhoneNumber());

        String accountNumber = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        accountNumber = accountNumber.substring(1, 11);
        user.setAccountNumber(accountNumber);

        if (!Objects.equals(registerUserDto.getEmail(), user.getEmail())){
            userRepository.save(user);
        }
        else {throw new IllegalArgumentException("Email Already Exists");}


        return "Account created";
    }

    @Override
    public String loginToAccount(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user == null){
            throw new IllegalArgumentException("User does not exists");
        }
        if (!Objects.equals(loginDto.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Password incorrect");
        }

        return "User logged in";
    }

    @Override
    public Double deposit(DepositDto depositDto) {
        User user = userRepository.findByAccountNumber(depositDto.getAccountNumber());

        if (user == null){
            throw new NullPointerException("Account does not exist");
        }
        if (Objects.equals(user.getAccountNumber(), depositDto.getAccountNumber())){
            user.setBalance(depositDto.getAmount() + user.getBalance());
            userRepository.save(user);

        }
        return user.getBalance();
    }
}
