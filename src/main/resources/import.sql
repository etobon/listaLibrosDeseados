INSERT INTO usuarios (username, password, create_at) VALUES ('etobon','123','2021-10-12');
INSERT INTO usuarios (username, password, create_at) VALUES ('lvalencia','123','2021-10-12');

INSERT INTO libros (codigo, title, publisher, published_date, authors, description, categories, lenguaje, isbn, thumbnail, preview_link) VALUES ('abc','titulo de prueba1','publisher','2021-10-12','Edison Tobon','descripcion','libro de ficcion','es','isbn-01','http://ww.google.com','http://www.thymeleaf.org');
INSERT INTO libros (codigo, title, publisher, published_date, authors, description, categories, lenguaje, isbn, thumbnail, preview_link) VALUES ('def','titulo de prueba2','publisher','2021-10-12','Edison Tobon','descripcion','libro de ficcion','es','isbn-01','http://ww.google.com','http://www.thymeleaf.org');

/*insertamos lista de deseos*/
INSERT INTO listas_deseos(nombre, descripcion, create_at, usuario_id) VALUES ('lista1','Lista de libros de Lina 1','2021-10-12',2);

/*asociamos listasItems*/
INSERT INTO listas_deseos_items (cantidad, lista_deseo_id, libro_id) VALUES (1,1,1);
INSERT INTO listas_deseos_items (cantidad, lista_deseo_id, libro_id) VALUES (1,1,2);


INSERT INTO listas_deseos(nombre, descripcion, create_at, usuario_id) VALUES ('lista2','Lista de libros de Lina 2','2021-10-12',2);

/*asociamos listasItems*/
INSERT INTO listas_deseos_items (cantidad, lista_deseo_id, libro_id) VALUES (1,2,1);
INSERT INTO listas_deseos_items (cantidad, lista_deseo_id, libro_id) VALUES (1,2,2);


INSERT INTO listas_deseos(nombre, descripcion, create_at, usuario_id) VALUES ('lista1','Lista de libros de Edison 1','2021-10-12',1);