package crudspringbootsecurityrest.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crudspringbootsecurityrest.business.EmployeeBusinessService;
import crudspringbootsecurityrest.model.Employee;

@RestController
@EnableAutoConfiguration
public class CRUDEmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDEmployeeController.class);
	
	@Value("${url.value.default.employee}")
	private String URL_FROM_PROPS;
	
	private static final String URL_VALUE_DEFAULT_EMPLOYEE = "/employee/createDefaultEmployee";
	
	@Autowired
	private EmployeeBusinessService businessService;	
	
	@RequestMapping(value = CRUDEmployeeController.URL_VALUE_DEFAULT_EMPLOYEE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, Object> createDefaultEmployee() {
        LOGGER.info("Request received to create Empoyee");
        Map<String, Object> response = null;
        try {
            final Employee employee = businessService.createEmployee("Carlos", "Torres", true);
            LOGGER.info("Employee created: " + employee.toString());
            response = new HashMap<>();
            response.put("STATUS", "SUCCESS");
            response.put("EMPLOYEE", employee);
        } catch (final Exception excp) {
            LOGGER.error("Request failed", excp);
            response.put("STATUS:FAILED", "FAILED: Employee not created");
        }
        LOGGER.info("Request served");
        return response;
    }
	
	@RequestMapping(value = "/employee/createFullEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> createFullEmployee(@RequestParam("name") final String name,
    													@RequestParam("lastName") final String lastName,
    													@RequestParam("active") final boolean active) {
        LOGGER.info("Request received to create Empoyee");
        Map<String, String> response = null;
        try {
            final Employee employee = businessService.createEmployee(name, lastName, active);
            LOGGER.info("Employee created: " + employee.toString());
            response = new HashMap<>();
            response.put("STATUS:SUCCESS", employee.toString());            
        } catch (final Exception excp) {
            LOGGER.error("Request failed", excp);
            response.put("STATUS:FAILED", "FAILED: Employee not created");
        }
        LOGGER.info("Request served");
        return response;
    }
	
	//localhost:8081//employee/createEmployeeWithDept?name=Pako&lastName=Pakete&active=true&empId=1
	@RequestMapping(value = "/employee/createEmployeeWithDept", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> createEmployeeWithDept(@RequestParam("name") final String name,
    														@RequestParam("lastName") final String lastName,
    														@RequestParam("active") final boolean active,
    														@RequestParam("empId") final String depId) {
        LOGGER.info("Request received to create Empoyee linked to Department");
        Map<String, String> response = null;
        try {
            final Employee employee = businessService.createEmployee(name, lastName, active, depId);
            LOGGER.info("Employee created: " + employee.toString());
            response = new HashMap<>();
            response.put("STATUS:SUCCESS", employee.toString());            
        } catch (final Exception excp) {
            LOGGER.error("Request failed", excp);
            response.put("STATUS:FAILED", "FAILED: Employee not created");
        }
        LOGGER.info("Request served");
        return response;
    }

}
