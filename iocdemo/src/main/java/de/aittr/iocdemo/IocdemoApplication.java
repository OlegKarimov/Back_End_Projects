package de.aittr.iocdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IocdemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(IocdemoApplication.class, args);
/*
		InterfaceTCPConnection connection = new TCPConnection();
		//DeliveryService internetDeliveryService = new InternetDeliveryService();
		InterfaceDeliveryService internetDeliveryService = new InternetDeliveryService(connection);
		Messanger messanger = new Messanger(internetDeliveryService);
		messanger.sendMessage("hallo");
		*/

		Messanger messanger = context.getBean(Messanger.class);
		messanger.sendMessage("hello");
	}

}
