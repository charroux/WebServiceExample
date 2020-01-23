# WebServiceExample

## Ajouter la librairie Spring Data

Spring Data => accès base de données
Ouvrir le fichier de configuration build.gradle
Ajouter la librairie au dependencies :

implementation('org.springframework.boot:spring-boot-starter-data-mongodb')

https://github.com/charroux/WebServiceExample/blob/master/build.gradle

Valider les changements => import changes (Intellij)

## Customiser la classe Car pour la rendre persistante

Ajouyter org.springframework.data.annotation.Id au champs plateNumber
Ajouter org.springframework.data.mongodb.core.mapping.Document à la classe Car

https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/Car.java

## Customiser le Web Service pour enregistrer et cherche des données

### Remplacer le tableau des voitures par une requête dans la base

Créer une interface : 

public interface CarRepository extends CrudRepository<Car,String> {

}

https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/CarRepository.java

Ajouter l'accès au repository dans le web service et modifier le constructeur du web service pour qu'il récupère les données dans la base :

	@Autowired
	CarRepository carRepository;
	
	public CarRentalService() {

		Iterable<Car> allCarJPA = carRepository.findAll();
		for (Car c: allCarJPA) {
			System.out.println(c);
		}
    }
    
https://github.com/charroux/WebServiceExample/blob/master/src/main/java/com/example/CarRental/CarRentalService.java


## Tester

### Installer MongoDB

https://docs.mongodb.com/manual/installation/

### Démarrer MongoDB

cd C:\Program Files\MongoDB\Server\4.2\bin

mongod --dbpath C:\data\db

