# Demo Docker container Ubuntu

- docker run -i -d --name container-ubuntu -p 8091:80 ubuntu
- docker ps 
- docker exec -i -t container-ubuntu /bin/bash
 -> apt update 
 -> apt install nginx -y
 -> service nginx status
 -> service nginx start
 -> cd /var/www/html/
 -> apt install nano
 -> nano index.html
Sortir du container, c'est avec exit


# Commande Docker compose

**démarrer les conteneurs d'un docker-compose**: docker compose up
**arrêter les conteneurs d'un docker-compose**: docker compose down 
**démarrer les conteneurs d'un docker-compose avec un le nom du fichier**: docker compose -f {path_to_docker_compose_file} up -d