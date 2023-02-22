package org.example;

public class Main {
    public static void main(String[] args){

        MakeApiRequest request = new MakeApiRequest();
        DisplayResponse displayResponse = new DisplayResponse();

       String response =  request.makeWikipediaApiRequest(args[0]);
       displayResponse.display(response);
        
    }
}