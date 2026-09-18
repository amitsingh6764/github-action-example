package com.nse.github.action.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nse.github.action.model.ClientCodeDtls;
import com.nse.github.action.repo.ClientRepository;


@RestController
public class Gitaction {
	
	private static final Logger log = LogManager.getLogger(Gitaction.class);
	
	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/getName")
	public String getName() {
		return "Hello Amit Singh what is going on!";
	}
	

	@GetMapping("/clientUpload")
	public ResponseEntity<?> clientUpload(@RequestParam String pan) {
		try {

			Optional<ClientCodeDtls> clientCodeDtls =clientRepository.findByCcdPan(pan);
			
			if (clientCodeDtls.isPresent()) {
			    ClientCodeDtls client = clientCodeDtls.get();

				log.info(clientCodeDtls);
			}
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientCodeDtls);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error while uploading client : " + e.getMessage());
		}
	}

}
