package com.bookcatalog.service;

import com.bookcatalog.entity.Publisher;
import com.bookcatalog.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
    }

    @Override
    public Publisher create(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Long id, Publisher publisher) {

        Publisher existing = getById(id);

        existing.setName(publisher.getName());

        return publisherRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }
}