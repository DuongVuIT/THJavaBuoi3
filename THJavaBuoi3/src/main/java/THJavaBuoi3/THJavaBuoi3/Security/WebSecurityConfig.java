package THJavaBuoi3.THJavaBuoi3.Security;

import THJavaBuoi3.THJavaBuoi3.Services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    protected BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    protected DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        System.out.println("filter");
        http.authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers("/").permitAll()
                            .requestMatchers("/webjars/**").permitAll()
                            .requestMatchers("/books/")
                            .hasAnyAuthority("USER", "CREATE", "EDITOR", "ADMIN")
                            .requestMatchers("/books/new").hasAnyAuthority("ADMIN", "CREATE")
                            .requestMatchers("/books/edit/**")
                            .hasAnyAuthority("ADMIN", "EDITOR").requestMatchers("/books/delete/**").hasAuthority("ADMIN").anyRequest()
                            .authenticated();
                })
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(handling -> handling.accessDeniedPage("/403"));

    return http.build();
    }
}
