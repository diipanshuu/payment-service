package dev.dipanshu.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RazorPayDto {
    @Setter
    private Integer amount;
    private String short_url;

}
