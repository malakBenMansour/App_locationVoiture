package lb.applicationstage.locationvoiture.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.Valid;


import lb.applicationstage.locationvoiture.entities.ERole;
import lb.applicationstage.locationvoiture.entities.Role;
import lb.applicationstage.locationvoiture.entities.User;
import lb.applicationstage.locationvoiture.jwt.JwtUtils;
import lb.applicationstage.locationvoiture.payload.request.LoginRequest;
import lb.applicationstage.locationvoiture.payload.request.SignupRequest;
import lb.applicationstage.locationvoiture.payload.response.JwtResponse;
import lb.applicationstage.locationvoiture.payload.response.MessageResponse;
import lb.applicationstage.locationvoiture.repository.RoleRepository;
import lb.applicationstage.locationvoiture.repository.UserRepository;
import lb.applicationstage.locationvoiture.service.UserDetailsImpl;
import lb.applicationstage.locationvoiture.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @Autowired
    UserDetailsServiceImpl userDetailsService;


    //http://localhost:8085/SpringMVC/api/auth/signin
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }


    //http://localhost:8085/SpringMVC/api/auth/signup
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userDetailsService.deleteUser(id);
    }

    @GetMapping("list/{id}")
    public User listUser(@PathVariable("id") Long id) {
        return userDetailsService.listUser(id);
    }

    @PutMapping("updateUser")
    public void updateUser(User user) {
        userDetailsService.updateUser(user);
    }

    @GetMapping("ListUser")
    public List<User> getList() {
        return userDetailsService.getList();
    }

    @PutMapping("adminUpdate/{id}")
    public void adminUser(@PathVariable Long id){
        userDetailsService.adminUser(id);
    }


}