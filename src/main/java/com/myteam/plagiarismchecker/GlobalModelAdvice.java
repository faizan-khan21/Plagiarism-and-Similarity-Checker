package com.myteam.plagiarismchecker;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

/**
 * Makes the logged-in username available to every Thymeleaf view as ${currentUsername},
 * so the shared navigation bar can show it without touching any existing controller.
 */
@ControllerAdvice
public class GlobalModelAdvice {

    @ModelAttribute("currentUsername")
    public String currentUsername(Principal principal) {
        return principal == null ? null : principal.getName();
    }
}
