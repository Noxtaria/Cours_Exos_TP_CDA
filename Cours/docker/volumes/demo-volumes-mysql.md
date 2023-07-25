# Docker volume avec une BDD

## Faire des tests avec workbench


`creation bdd` :
- docker run -p 13306:3306 --name mysql-docker-local -eMYSQL_ROOT_PASSWORD=Password -d mysql:latest


`creation bdd avec volume ` :
- docker run -p 13306:3306 --name mysql-docker-local -v demo-mysql:/var/lib/mysql -eMYSQL_ROOT_PASSWORD=Password  -d mysql:latest


`creation bdd avec volume, database et user ` :
- docker run -d --name my-mysql -e MYSQL_ROOT_PASSWORD=mysecretpassword -e MYSQL_DATABASE=mydatabase -e MYSQL_USER=myuser -e MYSQL_PASSWORD=mypassword -p 3306:3306 -v my-mysql-data:/var/lib/mysql mysql:latest


`Creation bdd avec volume, database, user et volume pour insertion de donnée (volume lié)` :

- docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=Password -e MYSQL_DATABASE=mydatabase -v /Users/Moham/Documents/docker/data/data.sql:/docker-entrypoint-initdb.d/script.sql -v mysql-data-test:/var/lib/mysql mysql:latest --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci