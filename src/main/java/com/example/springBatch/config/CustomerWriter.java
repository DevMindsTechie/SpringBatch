package com.example.springBatch.config;

import com.example.springBatch.entity.Customer;
import com.example.springBatch.repository.CustomerRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriter implements ItemWriter<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void write(Chunk<? extends Customer> chunk) throws Exception {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        customerRepository.saveAll(chunk);
    }
}
