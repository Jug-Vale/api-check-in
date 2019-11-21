package com.jugvale.api.checkin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jugvale.api.checkin.domain.Credential;

@Repository
public interface CredentialRepository extends MongoRepository<Credential, String> {}