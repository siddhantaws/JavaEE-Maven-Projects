package com.restfully.shop.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.restfully.shop.filter.BearerTokenFilter;
import com.restfully.shop.filter.HttpMethodOverride;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class ShoppingApplication extends Application
{
   private Set<Object> singletons = new HashSet<Object>();
   private Set<Class<?>> classes = new HashSet<Class<?>>();
   public ShoppingApplication()
   {
      singletons.add(new CustomerResource());
      classes.add(BearerTokenFilter.class);
      classes.add(HttpMethodOverride.class);
   }

   @Override
   public Set<Object> getSingletons()
   {
      return singletons;
   }
}
