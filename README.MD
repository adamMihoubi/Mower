# MOWER

## language et technologies 
**Java 8**

**Cucumber/gherkins**

**Junit 5**

**Lombok**

## Execution  

* Celui qui voudra exécuter le code sur l'éditeur devra pensez à installer les plugins (Lombok, Gherkins et Cucumber for java)
* Pour lancer le projet il y'a trois manières de faire : 
  * maven clean install, ce dernier exécutera tous les tests, y compris le test d'acceptance.
  * Lancer l'application à travers l'IDE (j'ai utilisé IntelliJ)
  * Enfin après le clean install, maven générera le JAR qui pourra être exécuté avec la commande java -jar <*.jar> en s'assurant de mettre le fichier d'input dans le même répertoire que le JAR