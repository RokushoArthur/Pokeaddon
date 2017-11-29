package com.pokemonaddon.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemonaddon.api.model.GamingDBUser;
import com.pokemonaddon.api.repository.GamingDBUserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private GamingDBUserRepository gamingDBUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<GamingDBUser> optionalUser = gamingDBUserRepository.findByEmail(email);
		GamingDBUser gamingDBUser = optionalUser.orElseThrow(() -> new UsernameNotFoundException("Incorrect username and/or password"));
		
		return new User(email, gamingDBUser.getPassword(), getPermissions(gamingDBUser));
	}

	private Collection<? extends GrantedAuthority> getPermissions(GamingDBUser gamingDBUser) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		gamingDBUser.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		
		return authorities;
	}

}
