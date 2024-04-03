@Configuration
@EnableWebSecurity
public class LssSecurityConfig {

  @Autowired
  private CustomWebAuthenticationDetailsSource authenticationDetailsSource;

  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
            .authenticationDetailsSource(authenticationDetailsSource)
    }
}