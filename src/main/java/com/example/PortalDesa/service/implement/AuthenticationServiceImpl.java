package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.exception.AppException;
import com.example.PortalDesa.exception.AuthException;
import com.example.PortalDesa.model.UserRole;
import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.model.Roles;
import com.example.PortalDesa.model.sequence.SequenceUsers;
import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.payload.ApiResponse;
import com.example.PortalDesa.payload.AuthenticationResponse;
import com.example.PortalDesa.payload.JwtLoginResponse;
import com.example.PortalDesa.payload.request.LoginRequest;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.repository.RoleRepo;
import com.example.PortalDesa.repository.SequenceUsersRepo;
import com.example.PortalDesa.repository.UserRoleRepo;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.security.JwtTokenProvider;
import com.example.PortalDesa.security.UserPrincipal;
import com.example.PortalDesa.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Timestamp;
import java.util.Collections;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    SequenceUsersRepo sequenceUsersRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Override
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){

        if(!checkPassword(registerRequest.getPassword(),registerRequest.getConfirmPassword())){
            return ResponseEntity.badRequest().body("Check your password again");
        }

        checkEmail(registerRequest.getEmail());
        checkUsername(registerRequest.getUsername());

        Roles roles =checkRole(registerRequest.getRole().toString());
        String skuFix=skuGenerator(registerRequest.getUsername(),roles.toString());
        Users users=new Users(
                skuFix,
                registerRequest.getName(),
                registerRequest.getAlamat(),
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                1
        );
        users.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        users.setRoles(Collections.singleton(roles));

        Users save= usersRepo.save(users);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getUsername(),
                        registerRequest.getPassword()
                )
        );
        String token=jwtTokenProvider.generateToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(save.getUsername()).toUri();
        return ResponseEntity.created(location).body(new JwtLoginResponse(
                token,
                roles.toString(),
                userPrincipal.getSku(),
                userPrincipal.getStatus(),
                userPrincipal.getName(),
                userPrincipal.getEmail()));
    }
    @Override
    public void registerSeed(@RequestBody RegisterRequest registerRequest) {

        Roles roles = checkRole(registerRequest.getRole().toString());
        String skuFix = skuGenerator(registerRequest.getUsername(), roles.toString());
        Users users = new Users(
                skuFix,
                registerRequest.getName(),
                registerRequest.getAlamat(),
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                1
        );
        users.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        users.setRoles(Collections.singleton(roles));
        Users save = usersRepo.save(users);
    }

    @Override
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Users user = usersService.findByUsername(loginRequest.getUsername());
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        UserRole userRole=userRoleRepo.findFirstBySku_user(userPrincipal.getSku());
        String role="";
        if(userRole.getRole_id()==1){
            role="ROLE_USER";
        }else if(userRole.getRole_id()==2){
            role="ROLE_ADMIN";
        }else{
            role="ROLE_MERCHANT";
        }

        if (userPrincipal.getStatus()!=1) throw new AuthException("User has been blocked");
        String token=jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtLoginResponse(
                token,
                role,
                userPrincipal.getSku(),
                userPrincipal.getStatus(),
                userPrincipal.getName(),
                userPrincipal.getEmail())
        );
    }

    @Override
    public Boolean checkPassword(String password, String confirmPassword){
        if(password.toString().equals(confirmPassword.toString())){
            return true;
        }
        return false;
    }

    @Override
    public Roles checkRole(String role){

        Roles roles;
        RoleName roleName=RoleName.ROLE_USER;
        if(role.equals(RoleName.ROLE_ADMIN.toString())){
            roleName=RoleName.ROLE_ADMIN;
        }else if(role.equals(RoleName.ROLE_MERCHANT.toString())){
            roleName=RoleName.ROLE_MERCHANT;
        }
        roles = roleRepo.findByName(roleName)
                .orElseThrow(() -> new AppException("User Role not set."));
        return roles;
    }

    @Override
    public String skuGenerator(String username,String role){
        String skuFinal="";
        String usr=sub_str(username);
        String awal="000";
        if(sequenceUsersRepo.existsByKey(usr)){
            SequenceUsers sequenceUsers = sequenceUsersRepo.findFirstByKey(usr);
            Integer val = Integer.parseInt(sequenceUsers.getLast_seq());
            String finalSeq = awal.concat(String.valueOf(val+1));
            sequenceUsers.setLast_seq(finalSeq);
            sequenceUsersRepo.save(sequenceUsers);

            skuFinal = usr+"-"+finalSeq ;
        }else{
            SequenceUsers sequenceUsers=new SequenceUsers(usr,"0001");
            sequenceUsersRepo.save(sequenceUsers);
            skuFinal = usr+"-0001";
        }

        return  skuFinal;
    }

    @Override
    public ResponseEntity<?> checkUsername(String username) {
        if(usersRepo.existsByUsername(username)){
            return new ResponseEntity(new ApiResponse(false,"Username Already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> checkEmail(String email) {
        if(usersRepo.existsByEmail(email)){
            return new ResponseEntity(new ApiResponse(false,"Email Address Already In Use!"),
                    HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @Override
    public String sub_str(String str) {
        return str.substring(0,4).toUpperCase();
    }
}
