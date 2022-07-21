package marjorie.com.simpleauth

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @GetMapping("/")
    fun home(): String {
        return "Welcome to Simple Auth App."
    }

    @GetMapping("/secret")
    fun secret(@AuthenticationPrincipal principal: OAuth2User): String {
        val name = principal.getAttribute<String>("name")
        return "There is no secret, $name."
    }
}