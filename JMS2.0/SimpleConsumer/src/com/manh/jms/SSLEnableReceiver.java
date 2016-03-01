package com.manh.jms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.net.ssl.KeyManager;
import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.apache.activemq.broker.SslBrokerService;
import org.apache.activemq.broker.SslContext;

/**
 * Demonstrates the problem that occurs when SSL and failover
 * are enabled
 */
public class SSLEnableReceiver 
{
    private static final String KEY_STORE_PASSWORD = "test123";
    private static final String TRUST_STORE_PASSWORD = "test123";
    private static final String KEY_STORE_FILE_NAME = "E:/Maven-Project/SimpleConsumer/src/myconsumer.ks";
    private static final String TRUST_STORE_FILE_NAME = "E:/Maven-Project/SimpleConsumer/src/myclient.ts";

    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) throws Exception 
    {
    	createQueueSession(createAndStartConnection(getKeyManager(), getTrustManager()));
    	System.out.println("Connected to  SSL ActiveMQ broker...");
    }


    private static KeyManager[]  getKeyManager()
    {
    	InputStream inputStream;
    	KeyManager km[] =null;
		try {
			inputStream = new FileInputStream(KEY_STORE_FILE_NAME);
			KeyStore keyStore = KeyStore.getInstance("JKS");
	    	keyStore.load(inputStream, KEY_STORE_PASSWORD.toCharArray());
	    	KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	    	keyManagerFactory.init(keyStore, KEY_STORE_PASSWORD.toCharArray());
	    	km = keyManagerFactory.getKeyManagers();    
		} catch ( KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException | UnrecoverableKeyException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return km;
    }
    
    private static TrustManager[]  getTrustManager()
    {
    	InputStream inputStream;
    	TrustManager tm[] =null;
		try {
			inputStream = new FileInputStream(TRUST_STORE_FILE_NAME);
			KeyStore trustStore = KeyStore.getInstance("JKS");
			trustStore.load(inputStream, TRUST_STORE_PASSWORD.toCharArray());
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(trustStore);
		     tm = trustManagerFactory.getTrustManagers();
		} catch ( KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return tm;
    }
    
    private static Connection createAndStartConnection(KeyManager[] km,TrustManager[]  tm)
    {
    	//Connect to SSL broker
    	ActiveMQSslConnectionFactory  activeMQSslConnectionFactory = new ActiveMQSslConnectionFactory("ssl://127.0.0.1:61617");
         activeMQSslConnectionFactory.setKeyAndTrustManagers(km, tm, new SecureRandom());
         
         //COMMENT OUT activeMQSslConnectionFactory.setKeyAndTrustManagers(km, tm, new SecureRandom()); AND UNCOMMENT THE NEXT STATEMENT AND IT WILL WORK
         //SslContext.setCurrentSslContext(new SslContext(km, tm, new SecureRandom()));
         
         Connection connection=null;
		try {
			connection = activeMQSslConnectionFactory.createConnection();
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return connection;
    }
    
    private static void createQueueSession(Connection connection)
    {
    	QueueSession session;
		try {
			session = (QueueSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue=SimpleConsumer.getQueue(session);
			QueueReceiver queueReceiver= (QueueReceiver)session.createReceiver(queue);
			queueReceiver.setMessageListener((message)->{System.out.println(message);});
			connection.setExceptionListener((exeption)->{System.err.println(exeption.getMessage());});
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    }
