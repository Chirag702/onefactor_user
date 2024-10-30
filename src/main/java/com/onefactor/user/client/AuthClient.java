package com.onefactor.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "onefactor-auth", url = "http://onefactor.in:8083")
public interface AuthClient {

	@GetMapping("/api/auth/validate")
	String validateUser(@RequestHeader("Authorization") String authHeader);
}
