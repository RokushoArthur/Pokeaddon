package com.pokemonaddon.api.model;

public enum Type {

	FIRE("Fire"),
	WATER("Water"),
	GRASS("Grass"),
	GROUND("Ground"),
	ROCK("Rock"),
	FLYING("Flying"),
	FIGHTING("Fighting"),
	ELECTRIC("Electric"),
	GHOST("Ghost"),
	PSYCHIC("Psychic"),
	DARK("Dark"),
	NORMAL("Normal"),
	STEEL("Steel"),
	ICE("Ice"),
	UNKNOW("Unknow"),
	DRAGON("Dragon"),
	FAIRY("Fairy"),
	BUG("Bug"),
	POISON("Poison");
	
	private final String typeName;
	
	private Type(String typeName) {
		this.typeName = typeName;
	}
	
	public String toString() {
		return typeName;
	}
}

	