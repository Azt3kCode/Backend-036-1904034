INSERT INTO usuarios (username, password, enabled, nombre, apellido, email)
VALUES ('alexis', '$2a$10Lh7V7Ba9D8AS9moIc.mRkANiy8HUJgy67v0amd0i', 1, 'Alexis', 'Taco', 'alexis.taco@uanl.edu.mx')
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email)
VALUES ('antonella', '$2a$10Lh7V7Ba9D8AS9moIc.mRkANiy8HUJgy67v0amd0i', 1, 'Antonella', 'Pizza', 'antonella.pizza@uanl.edu.mx')

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 1);

