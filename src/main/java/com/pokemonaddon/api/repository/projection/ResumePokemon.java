package com.pokemonaddon.api.repository.projection;

public class ResumePokemon {

	private Long pokedexId;
	private String name;
	private String pokedexDescription;
	private String typeOne;
	private String typeTwo;
	private String gender;
	private String ability;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	
	public ResumePokemon(Long pokedexId, String name, String pokedexDescription, String typeOne, String typeTwo,
			String gender, String ability) {
		super();
		this.pokedexId = pokedexId;
		this.name = name;
		this.pokedexDescription = pokedexDescription;
		this.typeOne = typeOne;
		this.typeTwo = typeTwo;
		this.gender = gender;
		this.ability = ability;
	}	
}
