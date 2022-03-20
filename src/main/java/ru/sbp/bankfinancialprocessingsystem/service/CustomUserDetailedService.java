package ru.sbp.bankfinancialprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.GlobalUser;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.GlobalUserRepository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Konstantin Filin
 */


@Component
public class CustomUserDetailedService implements UserDetailsService {

    @Autowired
    GlobalUserRepository globalUserRepository;

    @Autowired
    ClientsRepository clientsRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<GlobalUser> optionalGlobalUser = globalUserRepository.findById(username);
        if (!optionalGlobalUser.isPresent()) {
            throw new UsernameNotFoundException("User id = " + username + " not found.");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + optionalGlobalUser.get().getUserRole()));
        return new User(optionalGlobalUser.get().getUserLogin(), optionalGlobalUser.get().getUserPassword(), authorities);
    }


    public List<Clients> allUsers() {
        return (List<Clients>) clientsRepository.findAll();
    }

    public boolean saveUserData(Clients user) {
        Optional<Clients> userFromDB = clientsRepository.findById(user.getUserLogin());
        if (userFromDB.isPresent()) {
            return false;
        }
        clientsRepository.save(user);
        return true;
    }

    public boolean saveGlobalData(GlobalUser globalUser) {
        Optional<GlobalUser> globalUserFromDB = globalUserRepository.findById(globalUser.getUserLogin());
        if (globalUserFromDB.isPresent()) {
            return false;
        }
        globalUserRepository.save(globalUser);
        return true;
    }

    public GlobalUser getGlobalUser(String username) {
        Optional<GlobalUser> globalUserFromDB = globalUserRepository.findById(username);
        if(globalUserFromDB.isPresent()) {
            return globalUserFromDB.get();
        }else {
            return null;
        }
    }

    public Clients getClient(String username) {
        Optional<Clients> clientFromDB = clientsRepository.findById(username);
        if(clientFromDB.isPresent()) {
            return clientFromDB.get();
        }else {
            return null;
        }
    }


    public boolean deleteGlobalUser(String username){
        Optional<GlobalUser> globalUserFromDB = globalUserRepository.findById(username);
        if(globalUserFromDB.isPresent()) {
            globalUserRepository.delete(globalUserFromDB.get());
            return true;
        }
        return false;
    }

    public boolean deleteUserData(String username){
        Optional<Clients> userDataFromDB = clientsRepository.findById(username);
        if(userDataFromDB.isPresent()) {
            clientsRepository.delete(userDataFromDB.get());
            return true;
        }
        return false;
    }
}
