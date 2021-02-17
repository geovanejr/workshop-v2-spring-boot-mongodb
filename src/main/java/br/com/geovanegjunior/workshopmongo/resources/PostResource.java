package br.com.geovanegjunior.workshopmongo.resources;

import br.com.geovanegjunior.workshopmongo.domain.Post;
import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.dto.UserDTO;
import br.com.geovanegjunior.workshopmongo.service.PostService;
import br.com.geovanegjunior.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
