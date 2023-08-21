-- Démo utilisateur
SHOW GRANTS FOR 'root'@'localhost';

CREATE USER 'pierre'@'localhost' IDENTIFIED BY 'motdepase';

SHOW GRANTS FOR 'pierre'@'localhost';

GRANT ALL PRIVILEGES ON *.* TO 'pierre'@'localhost';

-- Cree un utilisateur
-- qui a les droits sur toutes les tables d'au moins 3 de vos BDD
CREATE USER 'toto'@127.0.0.1 IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON transaction.* TO 'toto'@127.0.0.1;
GRANT ALL PRIVILEGES ON ventes.* TO 'toto'@127.0.0.1;
GRANT ALL PRIVILEGES ON world.* TO 'toto'@127.0.0.1;

-- Cree un utilisateur
-- qui a les droits sur une BDD et une seul table (en lecture)
CREATE USER 'tata'@127.0.0.1 IDENTIFIED BY 'test';
GRANT SELECT ON  world.city TO 'tata'@127.0.0.1;

-- supprimer le premier utilisateur
DROP USER 'toto'@127.0.0.1;

REVOKE ALL PRIVILEGES ON *.* FROM 'tata'@127.0.0.1;
REVOKE SELECT ON world.city FROM 'tata'@127.0.0.1;



