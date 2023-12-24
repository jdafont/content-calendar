package dev.jfont.contentcalendar.repository;

import dev.jfont.contentcalendar.model.Content;
import dev.jfont.contentcalendar.model.Status;
import dev.jfont.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        content.add(new Content(1, "My first blog post", "basically it's just the first piece of content", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, ""));
    }
}
