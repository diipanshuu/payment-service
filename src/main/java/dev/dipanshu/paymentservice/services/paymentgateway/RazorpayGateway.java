package dev.dipanshu.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class RazorpayGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink() {
        return "";
    }
}
