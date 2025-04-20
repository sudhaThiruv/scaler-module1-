package dev.naman.mcproductservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class GetProductDetailsRequestDTO {
    private  String email;
    private  String password;
}
