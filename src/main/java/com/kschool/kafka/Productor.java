package com.kschool.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Productor extends Thread{
    
    Producer<String, String> kafkaProducer;
    ObjectMapper objectMapper;
    String elasticTopic;
    String systemName;
    FactoriaKpi factoriaKpi;

    public Productor(String systemName, String elasticTopic){
        
        this.objectMapper = new ObjectMapper();
        this.systemName = systemName;
        this.elasticTopic = elasticTopic;
        Producer kafkaProducer = new Producer(getProducerConfig());
        this.kafkaProducer = kafkaProducer;
        this.factoriaKpi = new FactoriaKpi();
    }

    private ProducerConfig getProducerConfig(){

    	Properties properties = new Properties();
    	properties.put("metadata.broker.list", "192.168.56.101:9092");
    	properties.put("serializer.class", "kafka.serializer.StringEncoder");
    	//properties.put("request.required.acks", "1");
    	return new ProducerConfig(properties);
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                
                String topic = this.elasticTopic;

                Thread.sleep(1000);
                if(topic != null) {
                	Kpi kpi =this.factoriaKpi.getKpi();
                	String json = objectMapper.writeValueAsString(kpi);
                	System.out.println("json:"+json);
                	kafkaProducer.send(new KeyedMessage<String, String>(topic, json));
                	
                } else {
                    System.err.println("The event type is null");
                }

            } catch(JsonProcessingException e) {
                System.out.println("No se puede convertir a JSON");
            }catch(Exception e) {
            	System.out.println("Error : "+ e.getMessage());
            }
        }
    }

    public void shutdown(){
        interrupt();
    }
}
