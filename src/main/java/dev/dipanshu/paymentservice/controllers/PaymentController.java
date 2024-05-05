package dev.dipanshu.paymentservice.controllers;

import dev.dipanshu.paymentservice.services.PaymentService;
import dev.dipanshu.paymentservice.services.paymentgateway.PaymentGateway;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PatchMapping("/payments")
    public String initiatePayment() {
        return paymentService.generatePaymentLink();
    }
}
