package com.springboot.project.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.project.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private UserService userService;
	
	public SecurityConfiguration(UserService userService) {
		super();
		this.userService = userService;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(this.userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests()
//				.requestMatchers(
//					"/registration**",
//					"/js/**",
//					"/css/**",
//					"/img/**",
//					"/preferences",
//					"/preferences/add",
//					"/preferences/save",
//					"/movies/**",
//					"/friends/**")
//				.anyRequest()
//				.permitAll()
//				.authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//			.logout()
//				.invalidateHttpSession(true)
//				.clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/login?logout")
//				.permitAll();
//		
//		http.authenticationProvider(daoAuthenticationProvider());
//		
//		return http.build();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests()
				.requestMatchers(
					"/static/**",
					"/static/images/**",
					"/images/**",
					"/registration**",
					"/js/**",
					"/css/**",
					"/img/**",
					"/resources/**",
					"/preferences/**",
					"/movies/**",
					"/friends/**")
				.permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll();
	
		http.authenticationProvider(daoAuthenticationProvider());
	
		return http.build();
	}
	
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
//	@Bean
//	   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/preferences").authenticated()
//                .requestMatchers("/preferences/save").authenticated()
//                .requestMatchers("/preferences/add").authenticated()
//                .anyRequest().permitAll()
//            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .defaultSuccessUrl("/preferences")
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutUrl("/logout")
//                .permitAll()
//            );
//        
//        return http.build();
//    }
}