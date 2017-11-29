package com.pokemonaddon.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pokemon.class)
public abstract class Pokemon_ {

	public static volatile SingularAttribute<Pokemon, Long> pokedexId;
	public static volatile SingularAttribute<Pokemon, PokemonMove> moveThree;
	public static volatile SingularAttribute<Pokemon, PokemonGender> gender;
	public static volatile SingularAttribute<Pokemon, PokemonMove> moveTwo;
	public static volatile SingularAttribute<Pokemon, String> pokedexDescription;
	public static volatile SingularAttribute<Pokemon, Type> typeOne;
	public static volatile SingularAttribute<Pokemon, PokemonMove> moveOne;
	public static volatile SingularAttribute<Pokemon, PokemonClassification> classification;
	public static volatile SingularAttribute<Pokemon, PokemonEvPoints> evPoints;
	public static volatile SingularAttribute<Pokemon, Type> typeTwo;
	public static volatile SingularAttribute<Pokemon, PokeItem> heldItem;
	public static volatile SingularAttribute<Pokemon, PokemonMove> moveFour;
	public static volatile SingularAttribute<Pokemon, String> name;
	public static volatile SingularAttribute<Pokemon, PokemonAbility> ability;
	public static volatile SingularAttribute<Pokemon, PokemonIvPoints> ivPoints;
	public static volatile SingularAttribute<Pokemon, PokemonStatusPoints> statusPoints;

}

