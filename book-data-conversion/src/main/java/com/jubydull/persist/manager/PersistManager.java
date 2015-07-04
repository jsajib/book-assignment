package com.jubydull.persist.manager;

import com.jubydull.persist.Persist;
import com.jubydull.persist.context.PersistContext;

public class PersistManager {

	public void persist(PersistContext context, Object object) {

		Persist persist = context.getPersist();
		persist.save(object);

	}
}
