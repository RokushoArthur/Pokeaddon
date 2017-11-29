package com.pokemonaddon.api.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "pokemon")
@Entity
public class Pokemon {

	@Id
	@Column(name = "pokedex_id")
	private Long pokedexId;

	@NotNull
	private String name;
	
	@Column(name = "pokedex_description")
	private String pokedexDescription;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "type_one")
	private Type typeOne;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_two")
	private Type typeTwo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PokemonGender gender;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PokemonClassification classification;
	
	@ManyToOne
	@JoinColumn(name = "pokemon_ability_id")
	private PokemonAbility ability;
	
	@ManyToOne
	@JoinColumn(name = "held_item_id")
	private PokeItem heldItem;
	
	@ManyToOne
	@JoinColumn(name = "move_one_id")
	private PokemonMove moveOne;
	
	@ManyToOne
	@JoinColumn(name = "move_two_id")
	private PokemonMove moveTwo;
	
	@ManyToOne
	@JoinColumn(name = "move_three_id")
	private PokemonMove moveThree;
	
	@ManyToOne
	@JoinColumn(name = "move_four_id")
	private PokemonMove moveFour;

	@Embedded
	private PokemonStatusPoints statusPoints;
	
	@Embedded
	private PokemonEvPoints evPoints;
	
	@Embedded
	private PokemonIvPoints ivPoints;

	public Long getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(Long pokedexId) {
		this.pokedexId = pokedexId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPokedexDescription() {
		return pokedexDescription;
	}

	public void setPokedexDescription(String pokedexDescription) {
		this.pokedexDescription = pokedexDescription;
	}

	public Type getTypeOne() {
		return typeOne;
	}

	public void setTypeOne(Type typeOne) {
		this.typeOne = typeOne;
	}

	public Type getTypeTwo() {
		return typeTwo;
	}

	public void setTypeTwo(Type typeTwo) {
		this.typeTwo = typeTwo;
	}

	public PokemonGender getGender() {
		return gender;
	}

	public void setGender(PokemonGender gender) {
		this.gender = gender;
	}

	public PokemonClassification getClassification() {
		return classification;
	}

	public void setClassification(PokemonClassification classification) {
		this.classification = classification;
	}

	public PokemonAbility getAbility() {
		return ability;
	}

	public void setAbility(PokemonAbility ability) {
		this.ability = ability;
	}

	public PokeItem getHeldItem() {
		return heldItem;
	}

	public void setHeldItem(PokeItem heldItem) {
		this.heldItem = heldItem;
	}

	public PokemonMove getMoveOne() {
		return moveOne;
	}

	public void setMoveOne(PokemonMove moveOne) {
		this.moveOne = moveOne;
	}

	public PokemonMove getMoveTwo() {
		return moveTwo;
	}

	public void setMoveTwo(PokemonMove moveTwo) {
		this.moveTwo = moveTwo;
	}

	public PokemonMove getMoveThree() {
		return moveThree;
	}

	public void setMoveThree(PokemonMove moveThree) {
		this.moveThree = moveThree;
	}

	public PokemonMove getMoveFour() {
		return moveFour;
	}

	public void setMoveFour(PokemonMove moveFour) {
		this.moveFour = moveFour;
	}

	public PokemonStatusPoints getStatusPoints() {
		return statusPoints;
	}

	public void setStatusPoints(PokemonStatusPoints statusPoints) {
		this.statusPoints = statusPoints;
	}

	public PokemonEvPoints getEvPoints() {
		return evPoints;
	}

	public void setEvPoints(PokemonEvPoints evPoints) {
		this.evPoints = evPoints;
	}

	public PokemonIvPoints getIvPoints() {
		return ivPoints;
	}

	public void setIvPoints(PokemonIvPoints ivPoints) {
		this.ivPoints = ivPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pokedexId == null) ? 0 : pokedexId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (pokedexId == null) {
			if (other.pokedexId != null)
				return false;
		} else if (!pokedexId.equals(other.pokedexId))
			return false;
		return true;
	}
}
