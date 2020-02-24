# WebServiceExample

## Ajouter la librairie Spring Data

Spring Data => accès base de données
Ouvrir le fichier de configuration build.gradle
Ajouter la librairie au dependencies :

implementation('org.springframework.boot:spring-boot-starter-data-mongodb')

https://github.com/charroux/WebServiceExample/blob/master/build.gradle

Valider les changements => import changes (Intellij)

Sous Eclipse : clic droit projet -> gradle -> update

## Customiser la classe Car pour la rendre persistante

Ajouter org.springframework.data.annotation.Id au champs plateNumber

Ajouter org.springframework.data.mongodb.core.mapping.Document à la classe Car

https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/Car.java

## Customiser le Web Service pour enregistrer et cherche des données

### Remplacer le tableau des voitures par une requête dans la base

Créer une interface : 

public interface CarRepository extends CrudRepository<Car,String> {

}

https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/CarRepository.java

Spring va implanter automatiquement cette interface. Vous bénéficierez alors des méthodes issues de CrudRepository : 

https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

Ajouter l'accès au repository dans le web service et modifier le constructeur du web service pour qu'il récupère les données dans la base :

	@Autowired
	CarRepository carRepository;
    
https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/CarRentalService.java


## Tester

### Installer MongoDB

https://docs.mongodb.com/manual/installation/

### Démarrer MongoDB

cd C:\Program Files\MongoDB\Server\4.2\bin

mongod --dbpath C:\data\db

# Ajouter une base SQL 

## Ajouter les librairies pour la base H2 à build.gradle 

	implementation('org.springframework.boot:spring-boot-starter-data-jpa')
	runtime("com.h2database:h2")

https://github.com/charroux/WebServiceExample/blob/master/build.gradle

## Customiser la classe Car pour la renndre persistante avec @Entity et @Id

https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/Car.java

## Creer une interface Repository pour accéder à la base SQL

## Utiliser l'interface dans le Web Service

## Vérifier le contenu de la base

Ajouter spring.h2.console.enabled=true au fichier application.properties

Open the H2 web console: http://localhost:8080/h2-console

In the login page make sure that you use jdbc:h2:mem:testdb as JDBC URL and org.h2.Driver as the Driver class.

