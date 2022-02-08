# erronkarestapi

# Helburua
Java proiektu hau, behin abiarazita, Mongo-ko datuak hartzen ditu eta C# proiektua restapi honetara konektatzen da.
Swagger eginda dago eta funtzionatzen du.

*eus.uni.dam paketea*
1. App.java --> Exekutatzen den programa da.
2. SpringConfiguration.java --> Proiektu osoko konfigurazio klasea da, hau da, konexio helbidea ezartzen du.
3. SpringFoxConfig.java --> Swagger egiteko klasea da.

*eus.uni.dam.controller paketea*
1. PartidaController.java --> Hainbat metodo daude kontsulta ezberdinak egiteko.

*eus.uni.dam.dao paketea*
1. PartidaDAO.java --> Konexioa egiten du Mongoko datubasearekin eta kolekzioarekin.

*eus.uni.dam.model paketea*
1. Partida.java --> Zer datu hartu behar dituen klasea da.

# Abiaraztea
Behin abiarazten da eta datu berriak sartzerakoan bakarrik eguneratzen dira.


# Klase diagrama
![T4](https://user-images.githubusercontent.com/75114146/152936488-85e0c9f9-b1f8-4fb3-95c2-1877eed8b48a.svg)

# Iturriak
Aurreko ariketak <br/>
https://github.com/imadariaga <br/>
https://docs.mongodb.com/manual/reference/operator/query/ <br/>
https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
