package ru.supreme.webdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.supreme.webdemo.model.AuthorEntity;
import ru.supreme.webdemo.repository.AuthorRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class WebDemoApplication {

    private final AuthorRepository authorRepository;

    /**
     * с помощью этой штуки спринг сериализует объекты в жсон и десериализует жсон в объекты
     * Используем, чтобы руками сериализовать наши объекты
     */
    private final ObjectMapper objectMapper;

    public WebDemoApplication(AuthorRepository authorRepository,
                              ObjectMapper objectMapper) {
        this.authorRepository = authorRepository;
        this.objectMapper = objectMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
    }


    /**
     * Это что то типа мейна
     * Сделал для теста, чтобы дернуть репозиторий без веба
     */
    @PostConstruct
    public void run() throws Exception {
        AuthorEntity authorEntity = this.authorRepository.findById(1L);
        List<AuthorEntity> authorEntityList = this.authorRepository.findAll();

        System.out.println("AuthorEntity: " + authorEntity);
        System.out.println("AuthorEntityList: " + authorEntityList);

        // или в json виде:

        String jsonAuthorEntity = objectMapper.writeValueAsString(authorEntity); // сериализуем объект в json
        String jsonAuthorEntityList = objectMapper.writeValueAsString(authorEntityList); // сериализуем объект в json
        System.out.println("---------OR IN JSON-----------");
        System.out.println(jsonAuthorEntity);
        System.out.println(jsonAuthorEntityList);
        System.exit(1);
    }
}
