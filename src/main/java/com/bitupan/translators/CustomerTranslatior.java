package com.bitupan.translators;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.bitupan.models.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerTranslatior implements DynamoDBTypeConverter<String, Customer>{

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convert(Customer customer) {      //customer object is converted into string
        try {
            return mapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Customer unconvert(String s) {          //customer value from the dynamoDb table is converted into the Customer object
        try {
            return mapper.readValue(s,Customer.class);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
}
