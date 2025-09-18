# OurSpace - Blogposts - üK223

Dieses Projekt beinhaltet 4 Entitäten, User, Authority, Role und Blogpost.

## Funktionen
* CRUD Methoden für User und Blogpost
* Es kann ein User erstellt werden, welcher Rollen und Blogposts hat. Der User kann mehrere Rollen und Blogposts haben.
* Es können jeweils Blogposts und User per ID abgerufen werden.
* Blogposts können vom Owner des Posts oder von einem Admin bearbeitet und gelöscht werden.
* Ein User mit der Rolle default kann nur Blogposts einsehen.

## Voraussetzungen

* IntelliJ auf Java Version 18
* Gradle Version 18
* Postgresql (Verwendung mit der IDE)

## Endpoints

Dies ist der Startpunkt aller Endpunkte ```http://localhost:8080```

Endpoints | Pfad                          | Beschreibung
-------- | ------------------------------ | --------
GET      | /blogpost/{blogpostId}         | Ruft einen Blogpost basierend auf die blogpostId auf
GET      | /blogpost/author/{authorId}    | Ruft alle Blogposts eines Authors auf (Hier wird die UserId verwendet)
GET      | /blogpost                      | Gibt alle Blogposts aus die in der Datenbank existieren
POST     | /blogpost/                     | Erstellt einen Blogpost
PUT      | /blogpost/{blogpostId}         | Updated einen Blogpost (Muss Owner oder Admin sein)
DELETE   | /blogpost/{blogpostId}         | Löscht einen Blogpost (Muss Owner oder Admin sein)

## Ausführen

1. ```git clone https://github.com/MysterionNY/BE_uek223_Me_Az_Le.git``` in cmd ausführen

2. Docker Desktop starten

3. Projekt in der IDE (IntelliJ) auswählen

4. in das Terminal diese Zeile reinschreiben: ```docker run --name postgres_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres```

5. Auf das database symbol klicken

![Database connection 1][dataCon1]

6. Auf das + klicken und Postgresql auswählen

![Database connection 2][dataCon2]

7. In die Felder User und Password "postgres" reinschreiben

8. Einmal auf "Test Connection" klicken, sofern es erfolgreich anzeigt auf "Apply" und dann "OK"

![Database connection 3][dataCon3]

9. Auf das gradle symbol klicken

10.  bookstore -> Tasks -> application -> bootrun

![Boot run][bootRun]

## Verwendung von Postman

1. In Postman auf Import klicken

![Postman][postman]

2. Die json aus dem repo auswählen und hinzufügen

3. Auf die 3 Punkte klicken und "Run" auswählen

![Run collection][runCollection]

4. Run OurSpace klicken

![Run OurSpace][runtest]

## Swagger

1. Öffne diese Website: http://localhost:8080/swagger-ui/index.html#/

2. Starte das testen :P


[startDocker]: images/start-docker.png
[bootRun]: images/bootRun.png
[dockerCompose]: images/docker-compose.png
[postman]: images/postman.png
[runCollection]: images/runCollection.png
[runtest]: images/runTest.png
[dataCon1]: images/databaseCon1.png
[dataCon2]: images/databaseCon2.png
[dataCon3]: images/databaseCon3.png
