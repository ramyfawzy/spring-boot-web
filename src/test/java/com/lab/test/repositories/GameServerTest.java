package com.lab.test.repositories;

import java.io.IOException;
import java.io.Serializable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runners.Parameterized.Parameter;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

@RunWith(value = Parameterized.class)
public class GameServerTest {

	@Parameter
	public String x;
	
	private static Logger logger = LoggerFactory.getLogger(GameServerTest.class);

	public GameServerTest() {

	}

	public static class SomeRequest implements Serializable {
		private static final long serialVersionUID = -9219245239607926971L;
		public String text;
	}

	public static class SomeResponse implements Serializable {
		private static final long serialVersionUID = 1128533415068024243L;
		public String text;
	}
	
	@Parameters(name = "Parameter {index} - {0}")
	public static String[] fillAmounts() {
		String[] amounts = new String[] { "Client message 1", "Client message 2", "Client message 3" };
		return amounts;
	}

	@BeforeClass
	public static void initServer() throws IOException {
		Server server = new Server();
		Kryo kryo = server.getKryo();

		try {
			server.bind(55223, 55224);
			kryo.register(GameServerTest.SomeRequest.class);
			kryo.register(GameServerTest.SomeResponse.class);
			server.start();
			server.addListener(new Listener() {

				@Override
				public void received(Connection connection, Object object) {
					logger.info("Server received : {}", ((GameServerTest.SomeRequest) object).text);
					SomeResponse response = new GameServerTest.SomeResponse();
					response.text = "Hello from server !";
					server.sendToTCP(connection.getID(), response);
				}
			});
		}
		catch (IOException ex) {
			System.out.println(ex);
		}

	}

	@Test
	public void initClients() throws IOException, InterruptedException {
		
		Client client1 = new Client();
		Client client2 = new Client();
		
		Kryo kryo1 = client1.getKryo();
		Kryo kryo2 = client2.getKryo();
		
		kryo1.register(GameServerTest.SomeRequest.class);
		kryo1.register(GameServerTest.SomeResponse.class);
		kryo2.register(GameServerTest.SomeRequest.class);
		kryo2.register(GameServerTest.SomeResponse.class);

		client1.start();
		client2.start();
		
		client1.connect(5000, "192.168.0.2", 55223, 55224);
		client2.connect(5000, "192.168.0.2", 55223, 55224);

		SomeRequest request1 = new GameServerTest.SomeRequest();
		request1.text = x;
		
		client1.sendTCP(request1);
		
		client1.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof SomeResponse) {
					SomeResponse response = (SomeResponse) object;
					logger.info("Server has responded to {}-{} with : {}", connection.getID(), connection.getEndPoint().toString(), response.text);
				}
			}
		});
		
		
		
		SomeRequest request2 = new GameServerTest.SomeRequest();
		request2.text = x;
		
		client2.sendTCP(request2);
		
		client2.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof SomeResponse) {
					SomeResponse response = (SomeResponse) object;
					logger.info("Server has responded to {}-{} with : {}", connection.getID(), connection.getEndPoint().toString() ,response.text);
				}
			}
		});

	}

}
