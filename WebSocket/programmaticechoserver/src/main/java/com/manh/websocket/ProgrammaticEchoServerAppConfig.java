package com.manh.websocket;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.server.*;

public class ProgrammaticEchoServerAppConfig implements ServerApplicationConfig 
{
   @Override
   public Set<ServerEndpointConfig> getEndpointConfigs(	Set<Class<? extends Endpoint>> endpointClasses) 
   {
	   Set<ServerEndpointConfig> configs=new HashSet<ServerEndpointConfig>();
	   configs.add(ServerEndpointConfig.Builder.create(ProgrammaticEchoServer.class, "programmaticecho").build());
	   return null;
   }

   @Override
   public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) 
   {
		return scanned;
   }
}
