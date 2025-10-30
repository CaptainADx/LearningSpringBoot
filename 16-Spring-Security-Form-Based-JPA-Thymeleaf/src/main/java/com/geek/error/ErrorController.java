package com.geek.error;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("/error")
	public String errorHandler(Principal p, Model model, Authentication authentication) {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String username = "Guest";
        if (authentication != null && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getName())) {
            username = authentication.getName();
        }

        model.addAttribute("user", username);
        return "error";
	}
}
