package com.pokemonaddon.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PokemonMove.class)
public abstract class PokemonMove_ {

	public static volatile SingularAttribute<PokemonMove, Integer> pp;
	public static volatile SingularAttribute<PokemonMove, String> name;
	public static volatile SingularAttribute<PokemonMove, Integer> accuracy;
	public static volatile SingularAttribute<PokemonMove, Long> id;
	public static volatile SingularAttribute<PokemonMove, Integer> power;
	public static volatile SingularAttribute<PokemonMove, Type> type;
	public static volatile SingularAttribute<PokemonMove, Category> category;
	public static volatile SingularAttribute<PokemonMove, String> peculiarities;
	public static volatile SingularAttribute<PokemonMove, MoveTarget> target;
	public static volatile SingularAttribute<PokemonMove, String> tmNumber;

}

