package dev.dipanshu.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import dev.dipanshu.paymentservice.utils.EpochTimestampGenerator;
import dev.dipanshu.paymentservice.utils.UniqueIdGenerator;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink() {

        RazorpayClient razorpay = null;
        try {
            razorpay = new RazorpayClient("rzp_test_PL8K9ufKXjTNzW", "Ar4eJL8Bhk9bWAwdTmGwWyWd");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", 1000);
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", true);
        paymentLinkRequest.put("first_min_partial_amount", 100);
        paymentLinkRequest.put("expire_by", EpochTimestampGenerator.generateEpochTimestamp());
        paymentLinkRequest.put("reference_id", UniqueIdGenerator.generateUniqueId());
        paymentLinkRequest.put("description", "Payment for policy no #23456");

        JSONObject customer = new JSONObject();
        customer.put("name", "+919000090000");
        customer.put("contact", "Gaurav Kumar");
        customer.put("email", "gaurav.kumar@example.com");
        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name", "Jeevan Bima");
        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://github.com/diipanshuu/payment-service");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = null;
        try {
            payment = razorpay.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }

        // Will return complete JSONObject
        // return payment.toString();

        // Will return just the payment link
        return payment.get("short_url");
    }
}
