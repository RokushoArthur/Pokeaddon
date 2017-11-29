CREATE TABLE pokemon_ability (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE poke_item(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(512) NOT NULL,
	item_type VARCHAR(30) NOT NULL,
	price INT
) Engine=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pokemon_move(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(512) NOT NULL,
	move_type VARCHAR(10) NOT NULL,
	category VARCHAR(10) NOT NULL,
	pp TINYINT NOT NULL,
	power TINYINT,
	accuracy TINYINT,
	peculiarities VARCHAR(512),
	target VARCHAR(20) NOT NULL,
	tm_number VARCHAR(5)	
) Engine=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pokemon (
	pokedex_id BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	pokedex_description VARCHAR(512),
	type_one VARCHAR(10) NOT NULL,
	type_two VARCHAR(10),
	gender VARCHAR(10) NOT NULL,
	classification VARCHAR(20) NOT NULL,
	pokemon_ability_id BIGINT(20) NOT NULL,
	held_item_id BIGINT(20),
	move_one_id BIGINT(20),
	move_two_id BIGINT(20),
	move_three_id BIGINT(20),
	move_four_id BIGINT(20),
	
	FOREIGN KEY (pokemon_ability_id) REFERENCES pokemon_ability(id),
	FOREIGN KEY (held_item_id) REFERENCES poke_item(id),
	FOREIGN KEY (move_one_id) REFERENCES pokemon_move(id),
	FOREIGN KEY (move_two_id) REFERENCES pokemon_move(id),
	FOREIGN KEY (move_three_id) REFERENCES pokemon_move(id),
	FOREIGN KEY (move_four_id) REFERENCES pokemon_move(id),
	
	hp SMALLINT NOT NULL,
	attack SMALLINT NOT NULL,
	defense SMALLINT NOT NULL,
	sp_attack SMALLINT NOT NULL,
	sp_defense SMALLINT NOT NULL,
	speed SMALLINT NOT NULL,
	
	ev_hp TINYINT NOT NULL,
	ev_attack TINYINT NOT NULL,
	ev_defense TINYINT NOT NULL,
	ev_sp_attack TINYINT NOT NULL,
	ev_sp_defense TINYINT NOT NULL,
	ev_speed TINYINT NOT NULL,
	
	iv_hp TINYINT NOT NULL,
	iv_attack TINYINT NOT NULL,
	iv_defense TINYINT NOT NULL,
	iv_sp_attack TINYINT NOT NULL,
	iv_sp_defense TINYINT NOT NULL,
	iv_speed TINYINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE pokemon_team(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	first_pokemon_id BIGINT(20) NOT NULL,
	second_pokemon_id BIGINT(20),
	third_pokemon_id BIGINT(20),
	fourth_pokemon_id BIGINT(20),
	fifith_pokemon_id BIGINT(20),
	sixth_pokemon_id BIGINT(20),
	
	FOREIGN KEY (first_pokemon_id) REFERENCES pokemon(pokedex_id),
	FOREIGN KEY (second_pokemon_id) REFERENCES pokemon(pokedex_id),
	FOREIGN KEY (third_pokemon_id) REFERENCES pokemon(pokedex_id),
	FOREIGN KEY (fourth_pokemon_id) REFERENCES pokemon(pokedex_id),
	FOREIGN KEY (fifith_pokemon_id) REFERENCES pokemon(pokedex_id),
	FOREIGN KEY (sixth_pokemon_id) REFERENCES pokemon(pokedex_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;
