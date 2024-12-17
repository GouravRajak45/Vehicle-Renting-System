package com.example.vra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username){
		User user = userRepository.findByEmail(username);
		if(user!=null) {
			UserDetailsImps detailsImps = new UserDetailsImps(user);
			return detailsImps;
		}else {
			throw new UsernameNotFoundException("User not Found");
		}
		
	}

}
