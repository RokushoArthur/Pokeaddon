package com.pokemonaddon.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PokemonEvPoints {

	@Column(name = "ev_hp")
	private int hp;
	
	@Column(name = "ev_attack")
	private int attack;
	
	@Column(name = "ev_defense")
	private int defense;
	
	@Column(name = "ev_sp_attack")
	private int spAttack;
	
	@Column(name = "ev_sp_defense")
	private int spDefense;
	
	@Column(name = "ev_speed")
	private int speed;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpAttack() {
		return spAttack;
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}

	public int getSpDefense() {
		return spDefense;
	}

	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
