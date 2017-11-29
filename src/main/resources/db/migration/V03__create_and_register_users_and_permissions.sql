CREATE TABLE gamingdb_user (
	id BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permission(
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission(
	user_id BIGINT(20) NOT NULL,
	permission_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, permission_id),
	FOREIGN KEY (user_id) REFERENCES gamingdb_user(id),
	FOREIGN KEY (permission_id) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO gamingdb_user(id, name, email, password) values (1, 'Administrator', 'admin@gamingdb.com', '$2a$10$ntALlFVxHZNy.3Vc3kvtCO837U.akGLifBE8S4dJ3L5WGmP7u.CIa');

INSERT INTO permission(id, description) values (1, 'ROLE_SAVE_GAME');
INSERT INTO permission(id, description) values (2, 'ROLE_SEARCH_GAME');
INSERT INTO permission(id, description) values (3, 'ROLE_DELETE_GAME');
INSERT INTO permission(id, description) values (4, 'ROLE_SAVE_POKEMON');
INSERT INTO permission(id, description) values (6, 'ROLE_DELETE_POKEMON');