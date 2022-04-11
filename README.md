# Lancement
## Introduction
L'api Animaux regroupe une collection complète d'animaux et vous permet de les gérer facilement.

Cette API prend en charge le type de média JSON et utilise le codage de caractères UTF-8.

Elle est actuellement reliée à l'application de fiche Animal créé sous Android [Lien du GIT](https://github.com/Joktaa/Animaux)

---
## Technologies

## Gradle
- version 17
- build

## Docker Compose
`docker-compose up`

## DATA
- import data.sql file

## BDD
- nom : bdd_animaux
- utilisateur : root
- mdp : root


- refaire un `docker-compose up`


- Pour des jeux de tests utiliser data.sql en lançant les insert

## Heroku
- Pour se connecter `heroku login`

- Pour récuperer la branche de Heroku `heroku git:remote -a animaux-api`

- Pour activer l'api `heroku ps:scale web=1`

- Pour désactiver l'api `heroku ps:scale web=0`

- Pour avoir les infos `heroku info -a animaux-api`

- Pour envoyer des modifications `heroku restart` -> `git push heroku master`

## BDD Keroku

- username :b518973ea6fdde

- mdp: ef4a6705

- host: eu-cdbr-west-02.cleardb.net

- db: heroku_9131acfccead30c


- Connection: `mysql -u b518973ea6fdde -pef4a6705 -h eu-cdbr-west-02.cleardb.net`
- Data: data-heroku.sql

## Documentation de l'API

| HTTP request | Description
| ------------- | ------------
| **GET** https://animaux-api.herokuapp.com/api/animaux | Récupère tous les animaux
| **GET** https://animaux-api.herokuapp.com/api/animal/{id} | Récupère l'animal passé en paramètre
| **POST** https://animaux-api.herokuapp.com/api/animal | Créer un animal
| **PUT** https://animaux-api.herokuapp.com/api/animal/{id} | Modifier un animal
| **DELETE** https://animaux-api.herokuapp.com/api/animal/{id}| Supprime l'animal passé en paramètre

---

## Postman Collection
Nous avons créé une collection Postman pour que vous puissiez facilement tester tous les points de terminaison de l'API sans avoir à développer et à coder.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/14102114-eaa917a9-53e2-423c-8f62-a7da5cf36ae0?action=collection%2Ffork&collection-url=entityId%3D14102114-eaa917a9-53e2-423c-8f62-a7da5cf36ae0%26entityType%3Dcollection%26workspaceId%3D6baa53a4-e9a6-4a5c-b7a0-6f3c418b5d06)
