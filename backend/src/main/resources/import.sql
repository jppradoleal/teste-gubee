insert into tech(name) values ('Java 10'), ('Kotlin'), ('Kafka'), ('Event Stream'), ('Redis'), ('MongoDB'), ('NodeJS'), ('Big Data Analytics'), ('Hadoop'), ('Pig'), ('Cassandra');
insert into target_market(name) values ('Ecommerce'), ('ERP'), ('Lojista que não desejam possuir ecommerce'), ('Loja fisica'), ('Telecom'), ('Venda direta'), ('Mobile First'), ('Digital Onboarding');
insert into product(name, description) values ('Gubee Integrador', 'Ferramenta de integração para marketplaces'), ('Gubee Fretes', 'Ferramenta para gestão e calculo de fretes'), ('Gubee AntiFraude', 'Ferramenta especialistas em detecção e prevenção à fraude');
-- Produto Gubee Integrador
insert into products_techs(product_id, tech_id) values (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6);
insert into products_targets(product_id, target_id) values (1, 1), (1, 2), (1, 3);
-- Produto Gubee Fretes
insert into products_techs(product_id, tech_id) values (2, 6), (2, 7);
insert into products_targets(product_id, target_id) values (2, 1), (2, 2), (2, 4);
-- Produto Gubee Antifraude
insert into products_techs(product_id, tech_id) values (3, 3), (3, 8), (3, 9), (3, 10), (3, 11);
insert into products_targets(product_id, target_id) values (3, 1), (3, 5), (3, 6), (3, 7), (3, 8);