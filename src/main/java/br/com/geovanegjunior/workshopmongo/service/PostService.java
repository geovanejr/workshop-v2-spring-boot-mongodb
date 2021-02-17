package br.com.geovanegjunior.workshopmongo.service;

import br.com.geovanegjunior.workshopmongo.domain.Post;
import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.dto.UserDTO;
import br.com.geovanegjunior.workshopmongo.repository.PostRepository;
import br.com.geovanegjunior.workshopmongo.repository.UserRepository;
import br.com.geovanegjunior.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {

        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent()) {
            throw new ObjectNotFoundException("Post não encontrado");
        }

        return post.get();
    }

    public List<Post> findByTitle(String title) {

        return postRepository.findByTitleContainingIgnoreCase(title);
    }
}
