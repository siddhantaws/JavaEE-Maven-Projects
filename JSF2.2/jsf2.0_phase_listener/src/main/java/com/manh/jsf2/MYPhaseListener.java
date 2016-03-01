package com.manh.jsf2;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MYPhaseListener implements PhaseListener 
{

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("After :-"+event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) 
	{
		System.out.println("Before :-"+event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}

}
