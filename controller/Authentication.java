package com.united.gan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.united.gan.model.AuthRequest;
import com.united.gan.service.AdminService;
import com.united.gan.service.RegistrationService;
import com.united.gan.utils.Constants;
import com.united.gan.utils.JwtUtil;


@RestController
@CrossOrigin(origins = Constants.ORIGIN, allowedHeaders = "*")
public class Authentication {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RegistrationService registrationService;
	@Autowired
	private AdminService adminService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome Arjita !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        
        return jwtUtil.generateToken(authRequest.getUserName()
                , registrationService.fetchUserByEmailId(authRequest.getUserName()).getId());
    }
    
    @PostMapping("/authenticateAdmin")
    public String generateAdminToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName()
                , adminService.fetchAdminByEmailIdAndPassword(authRequest.getUserName(), authRequest.getPassword()).getId());
    }


}
