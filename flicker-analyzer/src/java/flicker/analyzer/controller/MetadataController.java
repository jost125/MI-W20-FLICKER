package flicker.analyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MetadataController {

	@RequestMapping(value = "/api/v1/metadata", method = RequestMethod.GET)
	public String showV1MetadataAction() {
		return "api/v1/metadata";
	}
}
