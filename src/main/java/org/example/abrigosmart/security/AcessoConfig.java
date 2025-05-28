package org.example.abrigosmart.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AcessoConfig {

    @Bean
    UserDetailsService acessoUser() {

        UserDetailsService acesso =
                new InMemoryUserDetailsManager(User
                        .withUsername("voluntario")
                        .password("{noop}2805")
                        .roles("USER")
                        .build());
        return acesso;
    }
}


/*
* Para usar o email cadastrado, no login de acesso, o GPT sugeriu esse código, mas não sei se faz sentido
*
*
* @Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
        return new UsuarioDetails(usuario); // UsuarioDetails deve implementar UserDetails
    }
}
*
*
*@Configuration
public class SegurancaConfig {

    @Autowired
    private JWTAuthFilter jwtAuthFilter;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filtrarRota(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(request ->
                request.requestMatchers("/**").permitAll()
                       .anyRequest().authenticated())
            .userDetailsService(usuarioDetailsService)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement(servidor ->
                servidor.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

*
*
*public class UsuarioDetails implements UserDetails {

    private final Usuario usuario;

    public UsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRole().name()));
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail(); // Aqui o login será via email
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}

*
*
*
*
*
* */
