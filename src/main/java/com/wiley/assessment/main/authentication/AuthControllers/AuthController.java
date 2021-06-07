package com.wiley.assessment.main.authentication.AuthControllers;

import com.wiley.assessment.main.authentication.JwtUtils;
import com.wiley.assessment.main.authentication.services.UserInfoService;
import com.wiley.assessment.main.authentication.dto.AuthRequest;
import com.wiley.assessment.main.authentication.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping
public class AuthController {

    private AuthenticationManager authenticationManager;

    private UserInfoService userInfoService;

    private JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserInfoService userInfoService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userInfoService = userInfoService;
        this.jwtUtils = jwtUtils;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password.", e);
        }

        final UserDetails userDetails = userInfoService.loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
