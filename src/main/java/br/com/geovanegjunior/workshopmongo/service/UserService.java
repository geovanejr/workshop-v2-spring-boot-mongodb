package br.com.geovanegjunior.workshopmongo.service;

import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.dto.UserDTO;
import br.com.geovanegjunior.workshopmongo.repository.UserRepository;
import br.com.geovanegjunior.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(String id) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new ObjectNotFoundException("Usuário não encontrado");
        }
        return user.get();
    }

    public User insertUser(User user) {

        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {

        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void deleteUser(String id) {

        findById(id);
        userRepository.deleteById(id);
    }
}
