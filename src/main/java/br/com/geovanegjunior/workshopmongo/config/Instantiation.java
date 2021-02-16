package br.com.geovanegjunior.workshopmongo.config;

import br.com.geovanegjunior.workshopmongo.domain.User;
import br.com.geovanegjunior.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User us1 = new User(null, "Maria Brown", "maria@gmail.com");
        User us2 = new User(null, "Alex Green", "alex@gmail.com");
        User us3 = new User(null, "Bob Grey", "bob@gmail.com");
        User us4 = new User(null, "Geovane Junior", "geovane.gjunior@gmail.com");

        userRepository.deleteAll();
        userRepository.saveAll(Arrays.asList(us1, us2, us3, us4));

    }
}
