package com.jugvale.api.checkin.application;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jugvale.api.checkin.application.request.CheckinRequest;
import com.jugvale.api.checkin.domain.Credential;
import com.jugvale.api.checkin.service.CredentialService;

@RestController
@RequestMapping("/api/v1/checkin")
public final class CheckinResource {

	private static final String CHECKIN_CREATED = "/api/v1/checkin/{id}";
	
	@Autowired
	private CredentialService credentialService;
	
	@GetMapping("{id}")
	public ResponseEntity<Credential> getCheckinById(@PathVariable final String id) {
		final Optional<Credential> credential = credentialService.findById(id);
		
		if(credential.isPresent()) 
			return ResponseEntity.ok().body(credential.get());
		else 
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Credential> doCheckin(@RequestBody @Valid final CheckinRequest request, 
			final UriComponentsBuilder builder) {
		final Credential saved = credentialService.save(request.toCredential());
		
		final URI uri = builder.path(CHECKIN_CREATED).buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(saved);
	}
	
}
