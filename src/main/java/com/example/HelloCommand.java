package com.example;

import com.example.jsonImport.JsonImport;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.io.IOException;


@Command(name = "hello", description = "i'm greeting you from the cli",
    mixinStandardHelpOptions = true, version = "1.0")
public class HelloCommand implements Runnable {
    @Option(names = {"-n", "--name"}, defaultValue = "world")
    private String name;


    public static void main(String[] args) throws Exception {
        PicocliRunner.run(HelloCommand.class, args);

    }

    public void run() {
        // business logic here
        System.out.println("hello " + name);

        try {
            //getting data from the json file into an object :
            Object javaObject = JsonImport.JsonFileToObject(new File("C:\\Users\\MSI\\Desktop\\demo\\src\\main\\resources\\data.json"));

            //checking weather json file is empty
            if (javaObject == null) {
                System.out.println("json is null");
            } else
                System.out.println(javaObject.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

