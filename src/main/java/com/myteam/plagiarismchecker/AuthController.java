package com.myteam.plagiarismchecker;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

/**
 * Login page and account registration.
 * The POST /login itself is handled by Spring Security's filter, not by this class.
 */
@Controller
public class AuthController {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{3,30}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private static final int MIN_PASSWORD_LENGTH = 6;

    private final AppUserRepository users;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AppUserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model
    ) {
        String cleanUsername = username == null ? "" : username.trim();
        String cleanEmail = email == null ? "" : email.trim().toLowerCase();

        String error = validate(cleanUsername, cleanEmail, password, confirmPassword);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("username", cleanUsername);
            model.addAttribute("email", cleanEmail);
            return "register";
        }

        users.save(new AppUser(cleanUsername, cleanEmail, passwordEncoder.encode(password)));
        return "redirect:/login?registered";
    }

    private String validate(String username, String email, String password, String confirmPassword) {
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            return "Username must be 3-30 characters: letters, numbers or underscore.";
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return "Please enter a valid email address.";
        }
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return "Password must be at least " + MIN_PASSWORD_LENGTH + " characters.";
        }
        if (!password.equals(confirmPassword)) {
            return "Passwords do not match.";
        }
        if (users.existsByUsername(username)) {
            return "That username is already taken.";
        }
        if (users.existsByEmail(email)) {
            return "An account with that email already exists.";
        }
        return null;
    }
}
