package br.com.geovanegjunior.workshopmongo.resources;

import br.com.geovanegjunior.workshopmongo.domain.Post;
import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.dto.UserDTO;
import br.com.geovanegjunior.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = userService.findAll();
        List<UserDTO> listUserDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listUserDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping()
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO) {

        User user = userService.fromDTO(userDTO);
        user = userService.insertUser(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> updateUserById(@RequestBody UserDTO userDTO, @PathVariable String id) {

        User user = userService.fromDTO(userDTO);
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<Post>> findPostUser(@PathVariable String id) {

        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPost());
    }
}
