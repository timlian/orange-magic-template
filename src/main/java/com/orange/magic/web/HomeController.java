package com.orange.magic.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "homepage"})
public class HomeController {
	private static Log LOG = LogFactory.getLog(HomeController.class);
		
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		LOG.info("received get request");
		return "home";
	}
}
