package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
	static Map<String, List<String>> categoryToMembers = Map.of(
			"fruits", List.of("apples", "bananas", "pears", "blueberries"),
			"veggies", List.of("broccoli", "spinach", "eggplant")
	);

	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/info/{category}")
	public String category(@PathVariable("category") String category, Model model) {
		String name = "Harsha";
		List<String> members = categoryToMembers.getOrDefault(category, new ArrayList<>());
		model.addAttribute("category", category);
		model.addAttribute("name", name);
		model.addAttribute("members", members);

		return "info";
	}

}