package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistartionDto;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistartionDto userRegistrationDto() {
        return new UserRegistartionDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistartionDto registrationDto) {
		System.out.println(registrationDto.getPassword()+"  1");
		userService.save(registrationDto);
		System.out.println(registrationDto.getPassword()+"  2");
		return "redirect:/registration?success";
	}
}
















//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import net.javaguides.springboot.service.UserService;
//import net.javaguides.springboot.web.dto.UserRegistartionDto;
//
//@Controller
//@RequestMapping("/registration")
//public class UserRegistrationController {
//	
//
//	private UserService userService;
//	
//	
//
//	
//	public UserRegistrationController(UserService userService) {
//		super();
//		this.userService = userService;
//	}
//	
//	
//	@ModelAttribute("user")
//	public UserRegistartionDto userRegistartionDto()
//	{
//		return new UserRegistartionDto();
//	}
//	
//	
//	@GetMapping
//	public String showRegistrationForm()
//	{
//		return "registration";
//	}
//	
//	@PostMapping()
//	public String registerUserAccount(@ModelAttribute("user")UserRegistartionDto userRegistartionDto, Model m)
//	{
//		userService.save(userRegistartionDto);
//		return "redirect:/registration?success";
//		
//	}
//	
//	
//
//}
