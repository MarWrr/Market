package com.market.backend.market.api.controller.user;

import com.market.backend.market.model.Address;
import com.market.backend.market.model.Users;
import com.market.backend.market.model.dao.AddressDAO;
import com.market.backend.market.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private  AddressDAO addressDAO;

    public UserController(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @GetMapping("/{userID}/address")
    public ResponseEntity<List<Address>> getAddress(
            @AuthenticationPrincipal Users user, @PathVariable("userID") Long userID) {
            if(!userHasPremission(user, userID)){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        return ResponseEntity.ok(addressDAO.findByUser_Id(userID));
    }

    @PutMapping("/{userID}/address")
    public ResponseEntity<Address> putAddress(@AuthenticationPrincipal Users user, @PathVariable("userID") Long userID, @RequestBody Address address) {
        if(!userHasPremission(user, userID)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        address.setId(null);
        Users refUser = new Users();
        refUser.setId(userID);
        address.setUser(refUser);
        return ResponseEntity.ok(addressDAO.save(address));

    }

    private boolean userHasPremission(Users user, Long id){
        return user.getId() == id;
    }
}
