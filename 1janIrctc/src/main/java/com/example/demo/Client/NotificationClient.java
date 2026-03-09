package com.example.demo.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "27decNotificationApp",url = "http://localhost:8082")
public interface NotificationClient {

	@PostMapping("/email/{message}/{email}")
	public ResponseEntity<String> sendNotification(@PathVariable String message,@PathVariable String email);
}
