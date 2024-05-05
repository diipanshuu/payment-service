package dev.dipanshu.paymentservice.services;

import dev.dipanshu.paymentservice.services.paymentgateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewaySelector paymentGatewaySelector;

    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }
    public String generatePaymentLink() {
        // Add details in the DB

        return paymentGatewaySelector
                .getPaymentGateway().
                generatePaymentLink();
    }
}
