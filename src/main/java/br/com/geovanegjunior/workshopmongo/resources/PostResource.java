package br.com.geovanegjunior.workshopmongo.resources;

import br.com.geovanegjunior.workshopmongo.domain.Post;
import br.com.geovanegjunior.workshopmongo.resources.util.URL;
import br.com.geovanegjunior.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

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

    @GetMapping(value="/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {

        System.out.println("Texto: " + title);
        title = URL.decodeParam(title);
        List<Post> post = postService.findByTitle(title);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value="/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "title", defaultValue = "") String title,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        title = URL.decodeParam(title);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        System.out.println("Texto: " + title);
        System.out.println("Datamin: " + min);
        System.out.println("Datamax: " + max);

        List<Post> post = postService.fullSearch(title, min, max);
        return ResponseEntity.ok().body(post);
    }
}
