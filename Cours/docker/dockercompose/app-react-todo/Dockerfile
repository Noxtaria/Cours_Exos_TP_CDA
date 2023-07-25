# Étape 1 : Utilisation de l'image Node.js pour construire l'application
FROM node:14 AS builder

WORKDIR /usr/src/app

# Copier les fichiers package.json et package-lock.json pour installer les dépendances
COPY package.json .
COPY package-lock.json .

RUN npm install

# Copier tout le reste du code de l'application
COPY . .

# Exécution de la commande de build pour générer les fichiers finaux de l'application
RUN npm run build

# Étape 2 : Utilisation de l'image NGINX pour le déploiement de l'application
FROM nginx:alpine

# Supprimer la configuration par défaut de NGINX pour un déploiement propre
RUN rm -rf /usr/share/nginx/html/*

# Copier les fichiers construits à partir de l'étape précédente dans le répertoire de déploiement de NGINX
COPY --from=builder /usr/src/app/build /usr/share/nginx/html

# Exposer le port 80 pour accéder à l'application depuis l'extérieur
EXPOSE 80

# Démarrer le serveur NGINX
CMD ["nginx", "-g", "daemon off;"]
