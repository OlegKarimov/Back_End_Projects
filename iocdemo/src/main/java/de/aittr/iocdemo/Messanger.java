package de.aittr.iocdemo;

import org.springframework.stereotype.Component;

@Component
public class Messanger {
    private InterfaceDeliveryService service;

    public Messanger(InterfaceDeliveryService service) {

        this.service = service;
    }

    public void sendMessage(String msg){
        System.out.println("Send new message: "+ msg);
        System.out.println("Start sending");
       // InternetDeliveryService service = new InternetDeliveryService();
        service.deliveryMessage();
        System.out.println("finish");
    }

}
