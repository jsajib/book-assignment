package com.jubydull.persist.context;

import com.jubydull.persist.Persist;

public class PersistContext {
	
	private Persist persist ;

	public Persist getPersist() {
		return persist;
	}

	public void setPersist(Persist persist) {
		this.persist = persist;
	}
	
	public void exeutePersist(Object persistObject){
		persist.save(persistObject);
	}
}
