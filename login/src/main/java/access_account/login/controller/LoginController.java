package access_account.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import access_account.login.model.LoginModel;
import access_account.login.service.LoginService;
import access_account.login.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8081")
public class LoginController {

    @Autowired
    private LoginService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");


        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    
        userService.authenticateUser(username, password);
    
        String token = jwtUtil.generateToken(username);
    
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", "Login successful");
    
        return ResponseEntity.ok(response);
    }

}
