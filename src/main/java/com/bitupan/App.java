package com.bitupan;

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


        load(mapper);
    }

    private static void load(DynamoDBMapper mapper){
        //1. Basic Load
        Transaction t = new Transaction();
        t.setTransactionId("t1");
        t.setDate("20-07-2020");

        Transaction result  = mapper.load(t);
        System.out.println(result); // because we have used toString annotn in the Transaction Class it will work
    }
    private static void save(DynamoDBMapper mapper){}
    private static void query(DynamoDBMapper mapper){}
    private static void delete(DynamoDBMapper mapper){}

}
