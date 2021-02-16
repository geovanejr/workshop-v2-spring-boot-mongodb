package br.com.geovanegjunior.workshopmongo.service;

import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();

    }
}
