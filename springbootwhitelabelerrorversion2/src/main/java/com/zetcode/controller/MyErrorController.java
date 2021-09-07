package com.zetcode.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {
	
    // This will call a get request to return path which call a handled mapping method 
	// the property variable can be set server.error.path=/error in application.properties
	// spring seems to work only with the server.error.path so better to set it
	public String getErrorPath() {
		return "/error";
	}
	
	  @GetMapping("/error")
	    public String handleError(HttpServletRequest request, Model model) {
		  String errorPage = "error";
		  String pageTitle = "Error";
		  
		  Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		  
		  if(status != null) {
			  Integer statusCode = Integer.valueOf(status.toString());
			  if(statusCode == HttpStatus.NOT_FOUND.value()) 
			  {
				  pageTitle = "Page Not Found";
			  	  errorPage="error/404"; // location of html page
			  }
			  else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) 
			  {
				  pageTitle = "Internal Server Error";
			  	  errorPage="error/500"; // location of html page
			  }
			  else if(statusCode == HttpStatus.FORBIDDEN.value()) 
			  {
				  pageTitle = "Forbidden Error";
			  	  errorPage="error/403"; // location of html page
			  }
		  }
		  
	     return errorPage;
	    }

}
