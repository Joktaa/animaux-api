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
- Pour se connecter `heroku login`

- Pour récuperer la branche de Heroku `heroku git:remote -a animaux-api`

- Pour activer l'api `heroku ps:scale web=1`

- Pour désactiver l'api `heroku ps:scale web=0`

- Pour avoir les infos `heroku info -a animaux-api`

- Pour envoyer des modifications `heroku restart` -> `git push heroku master`

##BDD Keroku

- username :b518973ea6fdde

- mdp: ef4a6705

- host: eu-cdbr-west-02.cleardb.net

- db: heroku_9131acfccead30c


- Connection: `mysql -u b518973ea6fdde -pef4a6705 -h eu-cdbr-west-02.cleardb.net`



- Envoie des données de tests dans la BDD :
`Get-Content [lien du dossier]\src\main\resources\data-heroku.sql | mysql -u b518973ea6fdde -pef4a6705 -h eu-cdbr-west-02.cleardb.net`



