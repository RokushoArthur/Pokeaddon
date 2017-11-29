package com.pokemonaddon.api.repository.filter;

public class PokemonFilter {

	private String pokedexId;
	private String name;
	private String typeOne;
	private String typeTwo;
	private String ability;
	
	public String getPokedexId() {
		return pokedexId;
	}
	public void setPokedexId(String pokedexId) {
		this.pokedexId = pokedexId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOne() {
		return typeOne;
	}
	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}
	public String getTypeTwo() {
		return typeTwo;
	}
	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
}
