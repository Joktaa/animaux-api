# Lancement
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

##Heroku
-Pour se connecter `heroku login`

-Pour activer l'api `heroku ps:scale web=1`

-Pour désactiver l'api `heroku ps:scale web=0`

-Pour avoir les infos `heroku info -a animaux-api`

-Pour envoyer des modifications `heroku restart` -> `git push heroku master`




