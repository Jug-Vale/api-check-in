package com.jugvale.api.checkin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jugvale.api.checkin.domain.Credential;

@Repository
public interface CredentialRepository extends MongoRepository<Credential, String> {
	Optional<Credential> findByEmail(final String email);
}