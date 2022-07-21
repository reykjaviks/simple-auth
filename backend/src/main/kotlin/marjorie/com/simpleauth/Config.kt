package marjorie.com.simpleauth

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class Config: WebSecurityConfigurerAdapter() {
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.oauth2Login()

        httpSecurity.authorizeRequests()
            .mvcMatchers("/").permitAll()
            .anyRequest().authenticated()
    }
}