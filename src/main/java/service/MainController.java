package service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String home()
	{

	    return "Home";
	}

	@GetMapping("/Departments")
	public String departments()
	{

	    return "Departments";
	}


}
