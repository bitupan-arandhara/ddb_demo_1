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
    // @Override
    // public T unconvert(final Map<String,AttributeValue> object) {
    // final T result = StandardBeanProperties.DeclaringReflect.<T>newInstance(targetType);
    // if (!object.isEmpty()) {
    //     for (final DynamoDBMapperFieldModel<T,Object> field : fields()) {
    //         try {
    //             final AttributeValue value = object.get(field.name());
    //             if (value != null) {
    //                 field.unconvertAndSet(result, value);
    //             }
    //         } catch (final RuntimeException e) {
    //             throw new DynamoDBMappingException(
    //                 targetType.getSimpleName() + "[" + field.name() + "]; could not unconvert attribute", e
    //             );
    //         }
    //     }
    // }
    // return result;
    // }
    
}
