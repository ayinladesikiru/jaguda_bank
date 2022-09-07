package africa.semicolon.jaguda_bank.data.RequestDto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String name;
    private String accountNumber;
    private String password;
    private String phoneNumber;
    private String email;
}
