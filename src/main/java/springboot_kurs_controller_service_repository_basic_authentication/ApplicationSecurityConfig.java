package springboot_kurs_controller_service_repository_basic_authentication;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	
    @Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder = passwordEncoder;
	}
	
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.
		csrf().disable().// bu delete yapabilmek icin gerekli kod, security silinmesi ni engeller ama bu kodla onu kaldirmis oluruz sorumlulugu buz aliriz
		authorizeRequests(). // ben  her Request ler icin yetki sorulmasini istiyorum.
		antMatchers("/" , "index" , "/css/*", "/js/*").permitAll().// eger homepage,  index dosyasi, css kodu ve js kodu gorursen eger iziin ver sifre sorma
		anyRequest().
		authenticated().
		and().
		httpBasic();  //Ama basic authentication istiyorum yani her istekte user name ve password kotrol edilcek
	}

	//  @Configuration ve @Bean birlikte kullanilir bean tek basina kullanilmaz
	
	@Override
	@Bean // bu methodun olusturdugu obje yi ico gondercek bende nezaman istersenm kullanabilcem
	protected UserDetailsService userDetailsService() {
		
	UserDetails student =	User.builder().username("techproed").password(passwordEncoder.encode("12345")).roles("STUDENT").build(); // password(passwordEncoder.encode("12345")) sayesinde 12345 i sifreledik
	UserDetails admin =	User.builder().username("admin").password(passwordEncoder.encode("nimda")).roles("ADMIN").build();
		
	return new InMemoryUserDetailsManager(student,admin);
	}
	
	
	
	

}
  