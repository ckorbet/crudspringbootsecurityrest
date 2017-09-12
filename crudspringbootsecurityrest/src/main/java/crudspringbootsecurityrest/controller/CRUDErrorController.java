package crudspringbootsecurityrest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDErrorController implements ErrorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDErrorController.class);
	
	private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";

    public CRUDErrorController(final ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(final HttpServletRequest request) {
        return new ModelAndView("/errors/error", getErrorAttributes(request, false));
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(final HttpServletRequest request) {
        final Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
        final HttpStatus status = getStatus(request);
        return new ResponseEntity<Map<String, Object>>(body, status);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private boolean getTraceParameter(final HttpServletRequest request) {
        if (request.getParameter("trace") == null || request.getParameter("trace").isEmpty()) {
            return false;
        }
        return !"false".equals(request.getParameter("trace").toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(final HttpServletRequest request, final boolean includeStackTrace) {
        final RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    private HttpStatus getStatus(final HttpServletRequest request) {
        final Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception excp) {
            	LOGGER.error("", excp);
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
