package net.javaguides.springboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.web.dto.UserRegistartionDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistartionDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		System.out.println(user.getEmail() + "FETCHED");
		System.out.println(user.getPassword() + "PASSWORD");

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password ss.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

//	@Override
//	public User save(UserRegistartionDto userRegistartionDto) {
//		User user =new User(userRegistartionDto.getFirstName(),
//				userRegistartionDto.getLastName(), 
//				userRegistartionDto.getEmail(),
//				passwordEncoder.encode(userRegistartionDto.getPassword()), 
//				Arrays.asList(new Role("ROLE USER")));
//		return userRepository.save(user);
//	}
//
//
//
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	
//		User user =userRepository.findByEmail(username);
//		if(user ==null)
//		{
//			throw new UsernameNotFoundException("Invalid UserName or password");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRAuthorities(user.getRoles()));
//			
//	}
//	
//	
//	private Collection<? extends GrantedAuthority> mapRAuthorities(Collection<Role> roles)
//	{
//		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//	}

}
