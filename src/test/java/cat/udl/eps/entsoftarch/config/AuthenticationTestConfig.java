package cat.udl.eps.entsoftarch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by http://rhizomik.net/~roberto/
 */
@Configuration
public class AuthenticationTestConfig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER").and()
            .withUser("owner").password("password").roles("OWNER").and()
            .withUser("admin").password("password").roles("ADMIN");
    }
}