TP : Application de Suivi de la Qualité de l'Air

Contexte :
La qualité de l'air est une préoccupation majeure dans de nombreuses villes à travers le monde. Votre objectif est de créer une API REST qui permet aux utilisateurs de signaler la qualité de l'air à différents endroits et de consulter ces rapports pour obtenir des informations actualisées.

I. Fonctionnalités :

1. Création d'un Rapport :
    - Les utilisateurs peuvent créer un rapport en fournissant des détails tels que la localisation (latitude, longitude), la date et heure, le niveau de pollution (par exemple, faible, modéré, dangereux) et d'éventuels commentaires ou observations.

2. Consultation des Rapports :
    - Les utilisateurs peuvent rechercher des rapports en fonction de la localisation ou de la date. Ils peuvent également voir les rapports récents ou les plus consultés.

3. Mise à jour et Suppression :
    - Les utilisateurs peuvent mettre à jour ou supprimer leurs propres rapports.

4. Statistiques :
    - Proposez une route API pour obtenir des statistiques sur les rapports, comme le nombre total de rapports, la localisation avec le plus de rapports, etc.

II. Technologies et Architecture :

- Utilisez Spring Boot pour créer votre API REST.
- Adoptez une architecture hexagonale :
    - Domaine : Définissez vos entités comme Rapport et les ports nécessaires.
    - Infrastructure : Utilisez Spring Data JPA pour implémenter les détails de persistance.
    - API : Créez des contrôleurs REST pour interagir avec le service métier.


III. Authentification : 
- Utilisez Spring Security pour ajouter une authentification basique ou JWT, afin que seuls les utilisateurs authentifiés puissent créer, mettre à jour ou supprimer des rapports.

IV. Tests : 
- Rédigez des tests unitaires et d'intégration pour votre application.

V. Déploiement :
- Créez un dockerfile pour déployer l'application 