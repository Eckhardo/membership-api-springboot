package com.eki.membership.persistence.interfaces;

import java.io.Serializable;

public interface IWithId extends Serializable{

	Long getId();

	void setId(final Long id);

}
