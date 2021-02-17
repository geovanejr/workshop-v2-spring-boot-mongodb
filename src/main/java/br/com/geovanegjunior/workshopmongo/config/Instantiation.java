package br.com.geovanegjunior.workshopmongo.config;

import br.com.geovanegjunior.workshopmongo.domain.Post;
import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.repository.PostRepository;
import br.com.geovanegjunior.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User us1 = new User(null, "Maria Brown", "maria@gmail.com");
        User us2 = new User(null, "Alex Green", "alex@gmail.com");
        User us3 = new User(null, "Bob Grey", "bob@gmail.com");
        User us4 = new User(null, "Geovane Junior", "geovane.gjunior@gmail.com");

        Post post1 = new Post(null, sdf.parse("15/02/2021"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", us1 );
        Post post2 = new Post(null, sdf.parse("16/02/2021"), "Bom dia", "Acordei feliz hoje", us1);

        userRepository.saveAll(Arrays.asList(us1, us2, us3, us4));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
