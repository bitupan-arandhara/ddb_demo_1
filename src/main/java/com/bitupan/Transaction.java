package com.bitupan;


import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersionAttribute;
import com.bitupan.models.Customer;
import com.bitupan.translators.CustomerTranslatior;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@DynamoDBTable(tableName = "Transactions")  //the tableName should be the name of the table that you create on aws
public class Transaction {
    @DynamoDBHashKey(attributeName = "transactionId")   //partition key, attribute name should be same as in the table
    private String transactionId;
    @DynamoDBRangeKey(attributeName = "date")
    private String date;
    @DynamoDBAttribute(attributeName = "amount")
    private Integer amount;
    // @DynamoDBVersionAttribute(attributeName = "version")
    // private Long version;
    @DynamoDBAttribute(attributeName = "customer")
    //@DynamoDBTypeConverted(converter = CustomerTranslatior.class)
    private Map<String, String> customer;
    //private Customer customer;
    @DynamoDBAttribute(attributeName = "type")
    private String type;
}
