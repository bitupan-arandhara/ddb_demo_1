package com.bitupan;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.s3.model.Region;
import com.bitupan.env.EnvironmentVariables;

public class App 
{
    public static void main( String[] args )
    {
        AWSCredentialsProvider creds = new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(EnvironmentVariables.ACCESS_KEY,
                    EnvironmentVariables.SECRET_KEY)
        );
        AmazonDynamoDB ddbClient = AmazonDynamoDBClientBuilder.standard().withCredentials(creds).withRegion("ap-south-1").build();
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);


        //load(mapper);
        save(mapper);
    }

    private static void load(DynamoDBMapper mapper){
        //1. Basic Load
        Transaction t = new Transaction();
        t.setTransactionId("t1");
        t.setDate("20-07-2020");

        Transaction result  = mapper.load(t);
        System.out.println(result); // because we have used toString annotn in the Transaction Class it will work
    }
    private static void save(DynamoDBMapper mapper){
        Map<String, String> customer = new HashMap<String, String>();
        customer.put("customerId", "c2");
        customer.put("customerName", "Bitupan");
        Transaction t = new Transaction();
        t.setTransactionId("t3");
        t.setDate("22-07-2021");
        t.setAmount(45);
        t.setType("PURCHASE");
        t.setCustomer(customer);
        mapper.save(t);
    }
    private static void query(DynamoDBMapper mapper){}
    private static void delete(DynamoDBMapper mapper){}

}
