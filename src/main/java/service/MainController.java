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

	@GetMapping("/Department")
    public String department(@RequestParam(name = "department", required = true) String department, Model model)

    {
        model.addAttribute("department", department); // make the variable subject available in your html
        // this is where you call methods you've written to get information from your database, then store it a variable
        // and call model.addAttribute with that variable so you can use it in your html
        return "department";

        //model.addAttribute("teachers", teacherNames); // make the variable subject available in your html
        // this is where you call methods you've written to get information from your database, then store it a variable
        // and call model.addAttribute with that variable so you can use it in your html
    }


}

