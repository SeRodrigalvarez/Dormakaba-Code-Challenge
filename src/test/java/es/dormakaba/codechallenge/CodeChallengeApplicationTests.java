package es.dormakaba.codechallenge;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import es.dormakaba.codechallenge.credentialmanager.controller.request.CredentialCreatorRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.request.CredentialToUserAssginerRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.request.UserAuthorizerRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.request.UserCreatorRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.request.UserRevokerRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.response.CredentialCreatorResponse;
import es.dormakaba.codechallenge.credentialmanager.controller.response.UserCreatorResponse;
import es.dormakaba.codechallenge.iotsimulator.controller.response.DoorCreatorResponse;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodeChallengeApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

	@Test
	void happyPath() {
		UserCreatorRequest userCreatorRequest = new UserCreatorRequest();
		userCreatorRequest.name="Sergio";

		ResponseEntity<UserCreatorResponse> userCreatorResponse = restTemplate.postForEntity("/user", userCreatorRequest, UserCreatorResponse.class);

		assertEquals(HttpStatus.CREATED, userCreatorResponse.getStatusCode());

		UserCreatorResponse userCreatorResponseBody = userCreatorResponse.getBody();

		assertTrue(userCreatorResponseBody.id instanceof UUID);
		assertEquals("Sergio", userCreatorResponseBody.name);

		CredentialCreatorRequest credentialCreatorRequest = new CredentialCreatorRequest();
		credentialCreatorRequest.code="00000000";

		ResponseEntity<CredentialCreatorResponse> credentialCreatorResponse = restTemplate.postForEntity("/credential", credentialCreatorRequest, CredentialCreatorResponse.class);

		assertEquals(HttpStatus.CREATED, credentialCreatorResponse.getStatusCode());

		CredentialCreatorResponse credentialCreatorResponseBody = credentialCreatorResponse.getBody();

		assertTrue(credentialCreatorResponseBody.id instanceof UUID);

		CredentialToUserAssginerRequest credentialToUserAssginerRequest = new CredentialToUserAssginerRequest();
		credentialToUserAssginerRequest.credentialId=credentialCreatorResponse.getBody().id;

		ResponseEntity<String> credentialToUserAssignerResponse = restTemplate.postForEntity("/user/" + userCreatorResponseBody.id + "/assign", credentialToUserAssginerRequest, String.class);

		assertEquals(HttpStatus.OK, credentialToUserAssignerResponse.getStatusCode());
		assertEquals("OK", credentialToUserAssignerResponse.getBody());

		ResponseEntity<DoorCreatorResponse> doorCreatorResponse = restTemplate.postForEntity("/door", null, DoorCreatorResponse.class);

		assertEquals(HttpStatus.CREATED, doorCreatorResponse.getStatusCode());

		DoorCreatorResponse doorCreatorResponseBody = doorCreatorResponse.getBody();

		assertTrue(doorCreatorResponseBody.id instanceof UUID);

		UserAuthorizerRequest userAuthorizerRequest = new UserAuthorizerRequest();
		userAuthorizerRequest.doorId=doorCreatorResponseBody.id;

		ResponseEntity<String> userAuthorizerResponse = restTemplate.postForEntity("/user/"+ userCreatorResponseBody.id +"/authorize", userAuthorizerRequest, String.class);

		assertEquals(HttpStatus.OK, userAuthorizerResponse.getStatusCode());
		assertEquals("OK", userAuthorizerResponse.getBody());

		ResponseEntity<Boolean> doorAccessRequester = restTemplate.getForEntity("/door/" + doorCreatorResponseBody.id + "/requestAccess/" + credentialCreatorRequest.code, Boolean.class);

		assertEquals(HttpStatus.OK, doorAccessRequester.getStatusCode());
		assertTrue(doorAccessRequester.getBody());

		UserRevokerRequest userRevokerRequest = new UserRevokerRequest();
		userRevokerRequest.doorId=doorCreatorResponseBody.id;

		ResponseEntity<String> userRevokerReponse = restTemplate.postForEntity("/user/" + userCreatorResponseBody.id + "/revoke", userRevokerRequest, String.class);

		assertEquals(HttpStatus.OK, userRevokerReponse.getStatusCode());
		assertEquals("OK", userRevokerReponse.getBody());

		doorAccessRequester = restTemplate.getForEntity("/door/" + doorCreatorResponseBody.id + "/requestAccess/" + credentialCreatorRequest.code, Boolean.class);

		assertEquals(HttpStatus.OK, doorAccessRequester.getStatusCode());
		assertFalse(doorAccessRequester.getBody());
	}
}
