package com.github.hypersmp;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;




public class databaseHandler {




    public static void main(String[] args){

        String db_username = "admin";
        String db_password = "";

        String db_name = "smp_db";


        ConnectionString connString = new ConnectionString(
                String.format("mongodb+srv://%s:%s@cluster0.iggtb.mongodb.net/%s?retryWrites=true&w=majority\n", db_username, db_password, db_name)
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase(db_name);

        MongoCollection collection = database.getCollection("egg_data");

        System.out.println(collection.countDocuments());


    }


}
