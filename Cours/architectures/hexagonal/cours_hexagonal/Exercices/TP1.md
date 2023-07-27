# TP 1 Système de Gestion d'Événements avec Architecture Hexagonale

Vous travaillez pour une entreprise qui veut développer un système de gestion d'événements. L'idée est de permettre aux utilisateurs de créer des événements, de s'inscrire à ces événements et de voir une liste de tous les événements à venir.



- Modélisation du Domaine:
- Événement : Un événement a un identifiant unique, un titre, une date, une description et une liste de participants. 
- Participant : Un participant a un identifiant unique et un nom.

- Ports :

- EventService : C'est l'interface principale pour notre application. Elle devrait avoir les méthodes suivantes :
    - createEvent(titre, date, description): Créer un nouvel événement.
    - registerForEvent(eventId, participantId): Inscrit un participant à un événement.
    - listUpcomingEvents(): Liste tous les événements à venir.
    - findEventById(eventId): Trouve un événement par son ID.

- EventRepository : C'est le port secondaire pour accéder à la persistance des événements.
    - save(event): Enregistre ou met à jour un événement.
    - findById(id): Trouve un événement par son ID.
    - findAll(): Renvoie tous les événements.

- Infrastructure :
    EventRepositoryInMemoryImpl : C'est une implémentation de EventRepository qui stocke les événements en mémoire (par exemple, en utilisant une HashMap).

- Service :
    EventServiceImpl : Implémentez la logique métier en utilisant l'interface EventService et le port EventRepository pour accéder à la base de données.

- Adapter :
    ConsoleAdapter : Permet aux utilisateurs d'interagir avec le système via la console. Il devrait fournir un menu avec des options pour créer des événements, s'inscrire à des événements, et voir la liste des événements à venir