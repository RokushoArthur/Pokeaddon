package com.pokemonaddon.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GamingDBUser.class)
public abstract class GamingDBUser_ {

	public static volatile SingularAttribute<GamingDBUser, String> password;
	public static volatile ListAttribute<GamingDBUser, Permission> permissions;
	public static volatile SingularAttribute<GamingDBUser, String> name;
	public static volatile SingularAttribute<GamingDBUser, Long> id;
	public static volatile SingularAttribute<GamingDBUser, String> email;

}

