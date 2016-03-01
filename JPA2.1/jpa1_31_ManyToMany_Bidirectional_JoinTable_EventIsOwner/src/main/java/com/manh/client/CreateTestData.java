package com.manh.client;


import java.util.HashSet;

import javax.persistence.EntityManager;

import com.manh.entity.Event;
import com.manh.entity.Speaker;

public class CreateTestData {

    public static void createTestData(EntityManager em) {
        em.getTransaction().begin();

        // Create the first event with multiple speakers
        Event event = new Event();
        event.setId(1l);
        event.setName("JavaOne conference");
        event.setSpeakers(new HashSet());
        event.getSpeakers().add(new Speaker("John", "Smith", event,1l));
        event.getSpeakers().add(new Speaker("Joe", "Smith", event,2l));
        event.getSpeakers().add(new Speaker("Sang", "Shin", event,3l));

        // Persist event object
        em.persist(event);

        // Create the second event with multiple speakers
        Event event2 = new Event();
        event2.setId(2l);
        event2.setName("Passion Conference");
        event2.setSpeakers(new HashSet());
        event2.getSpeakers().add(new Speaker("Sang", "Shin", event2 ,4l));
        event2.getSpeakers().add(new Speaker("Shelly", "Lumm", event2 ,5l));
        event2.getSpeakers().add(new Speaker("Diane", "Woon", event2,6l));

        // Persist event object
        em.persist(event2);

        em.getTransaction().commit();

    }
}