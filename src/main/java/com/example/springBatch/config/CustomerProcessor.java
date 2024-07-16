package com.example.springBatch.config;

import com.example.springBatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    @Override
    public Customer process(Customer Customer) throws Exception {

        //If want to apply filter then uncomment below code
        /*if(Customer.getCountry().equals("united States")){
            return Customer;
        }else {
            return null;
        }*/

        return Customer;
    }
}
