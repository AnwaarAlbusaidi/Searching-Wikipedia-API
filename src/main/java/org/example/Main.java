package org.example;

public class Main {

    public static void main(String[] args){

        if (args.length == 0) {
            System.err.println("Please provide a search topic as a command line argument.");
            return;
        }
        MakeApiRequest request = new MakeApiRequest();
        DisplayResponse displayResponse = new DisplayResponse();

       // Make API request and display response
        String response = request.makeWikipediaApiRequest(args[0]);
        displayResponse.display(response);
        
    }
}