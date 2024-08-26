package authenticated_route.home.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authenticated_route.home.service.HomeService;
import authenticated_route.home.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:8081")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<Map<String, String>> getName(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwtToken);
        }

        String name = username != null ? homeService.getNameByUsername(username) : "Invalid token";

        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name);

        return ResponseEntity.ok(response);
    }
}
