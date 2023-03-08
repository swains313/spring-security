package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistartionDto;

public interface UserService  extends UserDetailsService{

	User save(UserRegistartionDto userRegistartionDto);
}
