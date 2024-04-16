package com.market.backend.market.service;

import com.market.backend.market.api.model.RegistrationBody;
import com.market.backend.market.exception.UserAlreadyExistException;
import com.market.backend.market.model.Klienci;
import com.market.backend.market.model.dao.LocalUserDAO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public Klienci registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
            || localUserDAO.findByLoginIgnoreCase(registrationBody.getLogin()).isPresent()){
          throw new UserAlreadyExistException();
        }
        Klienci klient = new Klienci();
        klient.setEmail(registrationBody.getEmail());
        klient.setImie(registrationBody.getImie());
        klient.setNazwisko(registrationBody.getNazwisko());
        //ENKRYPCJA HASEL - zrobic
        klient.setHaslo(registrationBody.getHaslo());
        return localUserDAO.save(klient);
    }

}
