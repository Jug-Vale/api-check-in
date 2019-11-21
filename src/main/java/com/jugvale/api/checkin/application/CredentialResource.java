package com.jugvale.api.checkin.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jugvale.api.checkin.domain.Credential;
import com.jugvale.api.checkin.service.CredentialService;

@RestController
@RequestMapping("/api/v1/credentials")
public final class CredentialResource {

	@Autowired
	private CredentialService credentialService;
	
	@GetMapping
	public ResponseEntity<List<Credential>> getAll() {
		return ResponseEntity.ok().body(credentialService.findAll());
	}
}
