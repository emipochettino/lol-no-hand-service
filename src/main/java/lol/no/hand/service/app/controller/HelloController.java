package lol.no.hand.service.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class HelloController {
	private static final String template = "Hello, %s!";

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ResponseEntity.ok(String.format(template, name));
	}
}
