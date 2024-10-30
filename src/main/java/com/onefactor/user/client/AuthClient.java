package com.onefactor.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "onefactor-auth", url = "http://localhost:8085")
public interface AuthClient {

	@GetMapping("/auth/validate")
	String validateUser(@RequestHeader("Authorization") String authHeader);
}
