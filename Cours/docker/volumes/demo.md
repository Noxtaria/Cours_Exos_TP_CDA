 # Créer un volume et l'utiliser avec 2 machines

 ### créer un volume + monter ce volume dans un container dans un dossier + créer un fichier dans le dossier + supprimer le container + vérifier que le volume existe toujours + remonter le volume sur un autre container + vérifier que les données sont les mêmes sur ce nouveau container.  

- docker volume create share
- docker volume ls
- docker run -itd --name=ubuntu1 -v share:/tmp ubuntu
- docker exec -it ubuntu1 bash
 -> cd tmp/
 -> ls
 -> echo "coucou" >> fichier.txt
- docker run -itd --name=ubuntu2 -v share:/tmp ubuntu
- docker exec -it ubuntu2 bash
 -> cd tmp
 -> cat fichier.txt
- docker stop $(docker ps -aq) && docker rm $(docker ps -aq)
- docker volume ls
- docker run -itd --name=ubuntu3 -v share:/tmp ubuntu
- docker exec -it ubuntu3 bash
 -> cd tmp
 -> ls