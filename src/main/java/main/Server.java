package main;
import static spark.Spark.*;

public class Server {
    
    public static void main(String[] arg){
        get("/hello", (request, response) -> "Hello World!");
    }
}