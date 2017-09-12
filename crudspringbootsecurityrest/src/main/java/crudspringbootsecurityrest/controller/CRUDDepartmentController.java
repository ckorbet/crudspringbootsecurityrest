package crudspringbootsecurityrest.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crudspringbootsecurityrest.business.DepartmentBusinessService;
import crudspringbootsecurityrest.model.Department;

@RestController
@EnableAutoConfiguration
public class CRUDDepartmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDDepartmentController.class);
	
	@Autowired
	private DepartmentBusinessService businessService;	
	
	@RequestMapping(value = "/department/createDefaultDepartment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> createDefaultDepartment() {
        LOGGER.info("Request received to create Department");
        Map<String, String> response = null;
        try {
            final Department department = businessService.createDepartment("My new Department");
            LOGGER.info("Department created: " + department.toString());
            response = new HashMap<>();
            response.put("STATUS:SUCESS", department.toString());            
        } catch (final Exception excp) {
            LOGGER.error("Request failed", excp);
            response.put("STATUS:FAILED", "Department not created");
        }
        LOGGER.info("Request served");
        return response;
    }
	
	@RequestMapping(value = "/department/createFullDepartment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> createFullDepartment(@RequestParam("name") final String name) {
        LOGGER.info("Request received to create Department");
        Map<String, String> response = null;
        try {
        	final Department department = businessService.createDepartment(name); 
        	LOGGER.info("Department created: " + department.toString());
            response = new HashMap<>();
            response.put("STATUS:SUCESS", department.toString());            
        } catch (final Exception excp) {
        	LOGGER.error("Request failed", excp);
            response.put("STATUS:FAILED", "Department not created");
        }
        LOGGER.info("Request served");
        return response;
    }
	
	@RequestMapping(value = "/department/getDepartmentById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> getDepartmentById(@RequestParam("depId") final String depId) {
        LOGGER.info("Request received to search Department by ID");
        Map<String, String> response = null;
        try {
        	final Department department = businessService.getDepartmentById(depId);
        	if(department!=null) {
        		LOGGER.info("Department found: " + department.toString());
        	} else {
        		LOGGER.info("Department not found");
        	}
        	response = new HashMap<>();
        	if(department!=null) {
        		response.put("STATUS:SUCESS", department.toString());
        	} else {
        		response.put("STATUS:SUCESS", "Department not found");
        	}            
        } catch (final Exception excp) {
        	LOGGER.error("Request failed", excp);
            response.put("STATUS:FAILED", "");
        }
        LOGGER.info("Request served");
        return response;
    }

}
