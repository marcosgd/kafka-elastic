package com.kschool;

import com.kschool.kafka.Productor;

public class KafkaService {
    public static void main(String[] args) {
         
    	String elasticTopic = "elasticTopic2";

        Integer partitions = 1;
        String processNanme = args.length == 0 ? "defaultName" : args[0];

        final Productor producer = new Productor(processNanme, elasticTopic);

        producer.start();
        
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
        
                producer.shutdown();
                System.out.println("Apagado!");
            }
        });
    }
}
