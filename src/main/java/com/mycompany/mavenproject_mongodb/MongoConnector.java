/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject_mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kmjit04
 */
public class MongoConnector {
    private final MongoClient mongoClient;
    private MongoDatabase db;

    public MongoConnector(String host, int port)
    {
        this.mongoClient = new MongoClient(host, port);
    }

    public MongoConnector(String host, long port, String username, String password)
    {
        String textUri = "mongodb://"+username+":"+password+"@"+host+":"+port;
        MongoClientURI uri = new MongoClientURI(textUri);
        this.mongoClient = new MongoClient(uri);
    }

    public boolean connectToDB(String dbName)
    {
        this.db = mongoClient.getDatabase(dbName);
        return this.db != null;    
    }

    public List<String> listAllDB()
    {
        List<String> ret = new LinkedList<>();
        MongoIterable<String> x = mongoClient.listDatabaseNames();
        for(String t : x)
        {
            ret.add(t.toString());
        }
        return ret;
    }
}
