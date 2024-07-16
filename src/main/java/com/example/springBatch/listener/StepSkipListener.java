package com.example.springBatch.listener;

import com.example.springBatch.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<Customer, Number> {

    Logger logger = LoggerFactory.getLogger(StepSkipListener.class);

    @Override
    public void onSkipInRead(Throwable t) {
        logger.info("A failure at read {}" , t.getMessage());
        SkipListener.super.onSkipInRead(t);
    }

    @Override
    public void onSkipInWrite(Number item, Throwable t) {
        logger.info("A failure at write {}, {}" , t.getMessage(), item);
        SkipListener.super.onSkipInWrite(item, t);
    }

    @SneakyThrows
    @Override
    public void onSkipInProcess(Customer item, Throwable t) {
        logger.info("Item {} was skipped due to exception {}" , new ObjectMapper().writeValueAsString(item) , t.getMessage());
        SkipListener.super.onSkipInProcess(item, t);
    }
}
