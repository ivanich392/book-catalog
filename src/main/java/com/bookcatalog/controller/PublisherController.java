package com.bookcatalog.controller;

import com.bookcatalog.entity.Publisher;
import com.bookcatalog.repository.PublisherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(
            PublisherRepository publisherRepository
    ) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @PostMapping
    public Publisher create(
            @RequestBody Publisher publisher
    ) {
        return publisherRepository.save(publisher);
    }

    @PutMapping("/{id}")
    public Publisher update(
            @PathVariable Long id,
            @RequestBody Publisher updated
    ) {

        Publisher publisher =
                publisherRepository.findById(id)
                        .orElseThrow();

        publisher.setName(updated.getName());
        publisher.setCountry(updated.getCountry());

        return publisherRepository.save(publisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }
}