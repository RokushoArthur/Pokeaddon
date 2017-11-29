package com.pokemonaddon.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PokeItem.class)
public abstract class PokeItem_ {

	public static volatile SingularAttribute<PokeItem, ItemType> itemType;
	public static volatile SingularAttribute<PokeItem, Integer> price;
	public static volatile SingularAttribute<PokeItem, String> name;
	public static volatile SingularAttribute<PokeItem, String> description;
	public static volatile SingularAttribute<PokeItem, Long> id;

}

