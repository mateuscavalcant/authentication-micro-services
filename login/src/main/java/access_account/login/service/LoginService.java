package access_account.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import access_account.login.model.LoginModel;
import access_account.login.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public LoginModel authenticateUser(String username, String password) {
        LoginModel user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found: " + username);
            throw new RuntimeException("Invalid credentials");
        }
    
        System.out.println("Password in db: " + user.getPassword());
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Failed in encode password");
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
    
}
