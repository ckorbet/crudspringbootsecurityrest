package crudspringbootsecurityrest.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * Simple client for Employee controller using Spring framework 
 * </p>
 */
public class CRUDEmployeeSimpleClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDEmployeeSimpleClient.class);
	
	public static final String REST_SERVICE_URI = "http://localhost:8081/employee/createDefaultEmployee";
	
	private static HttpHeaders getHeaders(){
        final String plainCredentials="ckorbet:123456";
        LOGGER.info("Created plain credentials for user:ckorbet & password:123456");
        final String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
         
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
	
	private static void createDefaultEmployeeClient() {
		LOGGER.info("Invoking 'createDefaultEmployee' REST service.....");		
        final RestTemplate restTemplate = new RestTemplate(); 
         
        HttpEntity<String> request = new HttpEntity<String>(CRUDEmployeeSimpleClient.getHeaders());
        LOGGER.info("Sending request.....");
        ResponseEntity<Map> response = restTemplate.exchange(CRUDEmployeeSimpleClient.REST_SERVICE_URI, HttpMethod.GET, request, Map.class);
        Map<String, String> usersMap = (HashMap<String, String>)response.getBody();
        LOGGER.info("Request received");         
    }
	
	public static final void main(final String args[]) {
		CRUDEmployeeSimpleClient.createDefaultEmployeeClient();
	}

}
