package africa.semicolon.jaguda_bank.data.RequestDto;

import lombok.Data;

@Data
public class DepositDto {
    private String accountNumber;
    private Double amount;

}
