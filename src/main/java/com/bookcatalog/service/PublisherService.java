package com.bookcatalog.service;

import com.bookcatalog.entity.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAll();

    Publisher getById(Long id);

    Publisher create(Publisher publisher);

    Publisher update(Long id, Publisher publisher);

    void delete(Long id);
}