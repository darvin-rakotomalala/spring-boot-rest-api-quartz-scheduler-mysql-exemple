## Exemple Spring Boot Quartz Scheduler
Dans ce projet, nous allons apprendre à planifier des tâches avec Spring Boot à l'aide de Quartz Scheduler 
en créant une simple application de planification de suppression des données dans MongoDB. 
Ce projet dispose deux applications :
- **spring-boot-rest-api-deletedata-mongodb** - un micro-service qui fait la suppression des données de plus de 3 mois dans MongoDB
- **spring-boot-quartz-scheduler-cronjob-example** - un micro-service qui appelle le "spring-boot-rest-api-data-mongodb" à partir de open feign et déclenche la suppression tous les 15 minutes par jour.

Nous utiliserons MySQL pour conserver le logs des travaux et autres données liées aux travaux.

### Qu'est-ce que Quartz ?
---
[Quartz](http://www.quartz-scheduler.org/) est une bibliothèque Java open source pour la planification des tâches. Il dispose d'un ensemble très riche de 
fonctionnalités, y compris, mais sans s'y limiter, les tâches persistantes, les transactions et le clustering.
<br/>
Vous pouvez programmer des Jobs à exécuter à une certaine heure de la journée, ou périodiquement à un certain intervalle, 
et bien plus encore. Quartz fournit une API fluide pour créer des tâches et les planifier.
<br/>
Les travaux Quartz peuvent être conservés dans une base de données, un cache ou en mémoire.

### Caractéristiques du quartz
---
* Quartz peut être intégré dans n'importe quelle application Java autonome.
* Quartz prend en charge des fonctionnalités telles que la transaction JTA et le clustering.
* Quartz peut exécuter une tâche à plusieurs reprises à un intervalle de temps donné.
* Il dispose de capacités de basculement et d'équilibrage de charge pour les exécutions de tâches.
* Il prend en charge les transactions XA (protocole de validation en deux phases pris en charge par la plupart des bases de données).
* Il prend en charge RMI (Remote Method Invocation), lui permettant ainsi d'être appelé depuis une autre application s'exécutant sur une autre JVM.
* Il gère les transactions JTA en utilisant JobStoreCMT, une sous-classe de JDBCJobStore.
* Les fonctionnalités de clustering rendent la disponibilité du planificateur très élevée car il utilise des fonctionnalités de basculement et d'équilibrage de charge.

### L'API Quartz
---
Les interfaces clés de l'API Quartz sont les suivantes :
* **Scheduler** - C'est l'API principale pour interagir avec le planificateur.
* **Job** - C'est une interface à implémenter par des composants que vous souhaitez faire exécuter par l'ordonnanceur du Framework Quartz.
* **JobDetail** - Il est utilisé pour définir des instances de Jobs.
* **Trigger** - Il s'agit d'un composant utilisé pour définir le calendrier d'exécution des tâches.
* **JobBuilder** - Il est utilisé pour créer des instances de JobDetail, qui définissent des instances de Jobs.
* **TriggerBuilder** - Il est utilisé pour créer des instances de déclencheur.

### Prérequis
---
Pour ce projet, vous auriez besoin des spécifications suivantes :
- Spring Boot v2.0+
- JDK v1.8+
- Maven 3+ ou Gradle 4+ - outil de construction
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)

### Dependances Maven
---
Dans ce projet nous allons utiliser les dependances Maven suivants :
- **Spring Web** - Pour inclure Spring MVC et utilise le tomcat comme conteneur intégré par défaut.
- **Spring Data JPA** - API de persistance Java et Hibernate.
- **Spring Data MongoDB** - Stocke les données et les récupère à partir de MongoDB.
- **Spring Boot DevTools** - dépendance pour les rechargements automatiques ou le rechargement en direct des applications.
- Pilote **MySQL** - Pilote JDBC (peut être n'importe quelle base de données que vous souhaitez utiliser).
- **Quartz** - Est une bibliothèque de planification du travail open source qui peut être intégré dans pratiquement toutes les applications Java.
- **Spring Cloud Open Feign** - Un client REST déclaratif pour les applications Spring Boot.

### Exigences fonctionnelles
---
Les exigences fonctionnelles permettent de satisfaire les besoins fonctionnels (metier) de l'entreprise.
L'application doit permettre de :
- Gérer la suppression :
	* Supprimer les données de plus de 3 mois dans MongoDB
- Job Cron :
	* Déclenche l'opération suppression tous les 15 minutes par jour

### Architecture technique
---
L'image suivante présente l'architecture globale du projet.<br/><br/>
![Architecture_QuartzScheduler](https://user-images.githubusercontent.com/75081354/140499330-a8652040-d0e4-4024-82f7-04d8cb13de31.jpg)

Le module au cœur du Spring Framework (Spring Core) repose fondamentalement sur un seul principe de conception objet : l’inversion de contrôle.

L'**Inversion de contrôle (Spring IOC)** permet au développeur de s'occuper uniquement du code metier (Exigences fonctionnelles) et c'est le Framework qui s'occupe du code technique (Exigences Techniques)

### Exécuter l'application
---
Pour tester l'application :
* Lancer d'abord le micro-service "spring-boot-rest-api-deletedata-mongodb" qui tourne avec un port : 8080
* Lancer ensuit le deuxième micro-service "spring-boot-quartz-scheduler-cronjob-example" qui tourne avec un port 8081

Console d'exécution : <br/><br/>
![Quartz_deleteData-result](https://user-images.githubusercontent.com/75081354/140496967-3a4eda01-1891-4b5a-9d5a-b977db9faf63.PNG)

Voilà. Nous avons créé avec succès un exemple de projet Spring Boot avec Quartz Scheduler. <br/>
Dans ce projet, nous avons construit deux projets Spring Boot entièrement fonctionnel qui permet de déclancher une opération de suppression des données dans une base de donnée MongoDB.
