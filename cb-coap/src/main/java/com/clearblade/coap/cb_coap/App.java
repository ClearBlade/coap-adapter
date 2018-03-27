package com.clearblade.coap.cb_coap;

import java.util.HashMap;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;

import com.clearblade.java.api.ClearBlade;
import com.clearblade.java.api.ClearBladeException;
import com.clearblade.java.api.InitCallback;
import com.clearblade.java.api.Message;

/**
 * Hello world!
 *
 */
public class App 
{
	// TODO Populate your system settings
	// These can be found in System Settings in ClearBlade Platform Web Console
	// ex. a483c4a90aacaea9cfbfe9a68d3b
	private static String SYSTEM_KEY = "<YOUR_SYSTEM_KEY>";
	// ex. A484C4A90BE0B2E4E1FDE497E89301
	private static String SYSTEM_SECRET = "<YOUR_SYSTEM_SECRET>";
	// ex. https://platform.clearblade.com
	private static String PLATFORM_URL = "<PLATFORM_URL>";
	// ex. tcp://staging.clearblade.com:1883
	private static String MESSAGING_URL = "<MESSAGING_URL>";
	
	// TODO Use or create a service user in ClearBlade Platform Web Console
	private static String EMAIL = "<EMAIL>";
	private static String PASSWORD = "<PASSWORD>";
	private static HashMap<String, Object> initOptions = new HashMap<String, Object>();
	private static Message message = null;
	private static boolean initFlag = false;

    public static void main( String[] args )
    {
    	boolean initStatus = initializeCB();
    	if(!initStatus) {
    		return;
    	}
    	
    	String clientID = "ClearBladeCOAPTest"; 
	    message = new Message(clientID);
	    
    	CoapClient client = new CoapClient("coap://californium.eclipse.org:5683/obs");

		System.out.println("SYNCHRONOUS");
		
		CoapResponse response = client.get();
		
		if (response!=null) {
			System.out.println(Utils.prettyPrint(response));
			String messagePayload = Utils.prettyPrint(response);
			message.publish("coap-test", messagePayload);
			
		} else {
			System.out.println("No response received.");
		}
    }
    
    private static boolean initializeCB() {
    	InitCallback initCallback = new InitCallback(){
    	    @Override
    	    public void done(boolean results){
    	    	initFlag = true;
    		}
    		@Override
    		public void error(ClearBladeException exception){ 
    		   //initialization failed, given a ClearBladeException with the cause
    	        System.out.println("CB init error: " + exception.getMessage());
    	    }
    	};
    	initOptions.put("platformURL", PLATFORM_URL);
		initOptions.put("messagingURL", MESSAGING_URL);
		initOptions.put("email", EMAIL);
		initOptions.put("password", PASSWORD);
		
		ClearBlade.initialize(SYSTEM_KEY, SYSTEM_SECRET, initOptions, initCallback);
		
		return initFlag;
    }
}

