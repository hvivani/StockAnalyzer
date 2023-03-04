package net.vivani.stock;

import java.io.*;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

/**
 * Hernan Vivani
 * 20230303 - vivani.net
 *
 */
public class StockAnalyzer 
{
    public static void main( String[] args )
    {
        int MAX_PARAM=2;
        String symbol="";
        String token="";
        
        System.out.println( "Hernan Vivani's Stock Analyzer" );

        if (args.length < MAX_PARAM){

          System.out.println ("Usage: ");
          System.out.println ("StockAnalyzer <symbol> <token> ");

        }else{
          
           symbol=args[0]; 
           token=args[1];
           
           System.out.println("Getting Price: ");
           getPrice(symbol, token);
           //System.out.println("Getting Quote: ");
           //getQuote(symbol, token);
        }


    
    }

    private static void getPrice(String symbol, String token){
    
        String URL="https://api.twelvedata.com/price?symbol=" + symbol + "&format=JSON&apikey=" + token;
        String body="";

        try{

           AsyncHttpClient client = new DefaultAsyncHttpClient();

              client.prepare("GET", URL)
                 .execute()
                 .toCompletableFuture()
                 .thenAccept(System.out::println)
                 .join();

            client.close();

         } catch ( IOException e ) {
            e.printStackTrace();
        }

        System.out.println(body);
    }

    private static void getQuote(String symbol, String token){

        String URL="https://api.twelvedata.com/quote?symbol=" + symbol + "&format=JSON&apikey=" + token;
        
        try{
           
           AsyncHttpClient client = new DefaultAsyncHttpClient();
              
              client.prepare("GET", URL)
                 .execute()
                 .toCompletableFuture()
                 .thenAccept(System.out::println)
                 .join();
            
            client.close();
         
         } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
