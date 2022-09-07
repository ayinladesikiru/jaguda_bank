package africa.semicolon.jaguda_bank.services;

import africa.semicolon.jaguda_bank.data.RequestDto.DepositDto;
import africa.semicolon.jaguda_bank.data.RequestDto.LoginDto;
import africa.semicolon.jaguda_bank.data.RequestDto.RegisterUserDto;
import org.springframework.stereotype.Service;

@Service
public interface Services {
    String createAccount(RegisterUserDto registerUserDto);

    String loginToAccount(LoginDto loginDto);

    Double deposit(DepositDto depositDto);
}
