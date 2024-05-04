package com.market.backend.market.service;

import com.market.backend.market.api.model.LoginBody;
import com.market.backend.market.api.model.RegistrationBody;
import com.market.backend.market.exception.UserAlreadyExistException;
import com.market.backend.market.model.Users;
import com.market.backend.market.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService, JWTService jwtService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }

    public Users registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
            || localUserDAO.findByLoginIgnoreCase(registrationBody.getLogin()).isPresent()){
          throw new UserAlreadyExistException();
        }

        Users client = new Users();
        client.setLogin(registrationBody.getLogin());
        client.setEmail(registrationBody.getEmail());
        client.setName(registrationBody.getName());
        client.setSurname(registrationBody.getSurname());

        client.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));

        return localUserDAO.save(client);
    }

    public String loginUser(LoginBody loginBody){
        Optional<Users> opUser = localUserDAO.findByLoginIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()) {
            Users user = opUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }


}
