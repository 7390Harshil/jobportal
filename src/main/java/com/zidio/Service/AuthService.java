package com.zidio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.DTO.AuthResponse;
import com.zidio.DTO.LoginRequest;
import com.zidio.DTO.RegisterRequest;
import com.zidio.Entity.Admin;
import com.zidio.Entity.User;
import com.zidio.Enum.Role;
import com.zidio.Repository.AdminRepository;
import com.zidio.Repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;  // Inject AdminRepository

    public AuthResponse register(RegisterRequest request) {
        // Check if email already exists in users table
        if (userRepository.findByEmail(request.email) != null) {
            throw new RuntimeException("User with this email already exists");
        }

        // Save User entity in users table
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);  // Plain text for now
        user.setRole(request.role);
        userRepository.save(user);

        // If role is ADMIN, also save an Admin entity in admins table
        if (request.role == Role.ADMIN) {
            Admin admin = new Admin();
            admin.setEmail(request.email);
            admin.setRole(Role.ADMIN);
            admin.setActive(true);  // default active
            adminRepository.save(admin);
        }

        return new AuthResponse(null, user.getRole(), "User registered successfully");
    }

    public Object login(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
