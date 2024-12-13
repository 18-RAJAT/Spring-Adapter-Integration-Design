package com.adapterdesignpattern.adapterDesignPattern;

import com.adapterdesignpattern.adapterDesignPattern.request.PaymentRequest;
import com.adapterdesignpattern.adapterDesignPattern.response.PaymentResponse;
import com.adapterdesignpattern.adapterDesignPattern.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/payment")
public class AdapterDesignPatternApplication {

	private final PaymentService paymentService;

	public AdapterDesignPatternApplication(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/process")
	public PaymentResponse processPayment(@RequestBody PaymentRequest paymentRequest) {
		// Dynamically set the gateway from the JSON request
		String gateway = paymentRequest.getGateway();
		return paymentService.processPayment(gateway, paymentRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(AdapterDesignPatternApplication.class, args);
	}
}

/*

FOR CUSTOM API CALL


package com.adapterdesignpattern.adapterDesignPattern;

		import com.adapterdesignpattern.adapterDesignPattern.request.PaymentRequest;
		import com.adapterdesignpattern.adapterDesignPattern.response.PaymentResponse;
		import com.adapterdesignpattern.adapterDesignPattern.service.PaymentService;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/payment")
public class AdapterDesignPatternApplication {

	private final PaymentService paymentService;

	public AdapterDesignPatternApplication(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/{gateway}")
	public PaymentResponse processPayment(@PathVariable String gateway, @RequestBody PaymentRequest paymentRequest) {
		return paymentService.processPayment(gateway, paymentRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(AdapterDesignPatternApplication.class, args);
	}
}
*/