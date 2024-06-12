package com.example.util;

import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;



@Component
public class LoggerUtil {
		Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

	 	@Value("${spring.application.name}")
	    private String app;
	    @Value("${spring.application.version}")
	    private String version;


	    @Async
	    public void info(String idProcess, Object message) {    	
	    	
	    	Map<String, Object> msgObj = new HashMap<>();
	    	
	    		msgObj.put("version", version);
		    	msgObj.put("message", message);
				msgObj.put("idProcess", idProcess);
		    	msgObj.put("index", app);
		    	msgObj.put("app", app);
		    	msgObj.put("eventDate", DateUtils.getDateString("yyyy-MM-dd'T'HH:mm:ss.SS"));
		    	msgObj.put("typeStatusCode", "200");
		    	msgObj.put("type", "info");
	    	
			String msg = GSonUtils.serialize(msgObj);

			logger.info(msg);
	    }

  		/**
	     * @param map Map<String, String> map = new HashMap<>();
	     *            m.put("solicitudX", "12345");
	     * @param tag auditoria, metricas, proceso, etc.
	     */
	    @Async
	    public void telemetry(String tag, String action, Object message) {
	        	Map<String, String> logMap = new HashMap<>();
	            
	            logMap.put("version", version);
	            logMap.put("index", app);
	            logMap.put("app", app);
	            logMap.put("action", action);
	            logMap.put("tag", tag);
	            logMap.put("eventDate", String.valueOf(DateUtils.getDateString("yyyy-MM-dd'T'HH:mm:ss.SS")));
	            logMap.put("typeStatusCode", "200");
	            logMap.put("type", "info");
	            logMap.putAll(GSonUtils.deserializeFlat(GSonUtils.serialize(message)));
		        logger.info("Log {}",GSonUtils.deserializeFlat(GSonUtils.serialize(logMap)));
	    }

 		@Async
		public void infoService(String index, Object request, Object response, Object message) {

			Map<String, Object> msgObj = new HashMap<>();

			msgObj.put("index", app);
			msgObj.put("idProcess", index);
			msgObj.put("version", version);
			msgObj.put("message", message);
			msgObj.put("request", request);
			msgObj.put("response", response);
			msgObj.put("app", app);

			String msg = GSonUtils.serialize(msgObj);
			logger.info(msg);

		}
	    
	    
	    @Async
	    public void error(String idProcess, Object message, String cause) {    	
	    	
	    	Map<String, Object> msgObj = new HashMap<>();
	    	
		    	msgObj.put("version", version);
		    	msgObj.put("message", message);
		    	msgObj.put("idProcess", idProcess);
		    	msgObj.put("index", app);
		    	msgObj.put("app", app);
		    	msgObj.put("eventDate", DateUtils.getDateString("yyyy-MM-dd'T'HH:mm:ss.SS"));
		    	msgObj.put("typeStatusCode", "500");
		    	msgObj.put("type", "error");
		    	msgObj.put("cause", cause);
		    	
			String msg = GSonUtils.serialize(msgObj);
			logger.error(msg);
			
	    }
	    	    
	  
	}
