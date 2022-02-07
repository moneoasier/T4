# erronkarestapi

# Helburua
Java proiektu hau, behin abiarazita, Mongo-ko datuak hartzen ditu eta C# proiektua restapi honetara konektatzen da.
Swagger eginda dago eta funtzionatzen du.

*eus.uni.dam paketea*
1. App.java --> Exekutatzen den programa da.
2. SpringConfiguration.java --> Proiektu osoko konfigurazio klasea da, hau da, konexio helbidea ezartzen du.
3. SpringFoxConfig.java --> Swagger egiteko klasea da.

*eus.uni.dam.controller paketea*
1. EskatzaileaControler.java --> Hainbat metodo daude kontsulta ezberdinak egiteko.

*eus.uni.dam.dao paketea*
1. PartidaDAO.java --> Konexioa egiten du Mongoko datubasearekin eta kolekzioarekin.

*eus.uni.dam.model*
1.Partida.java --> Zer datu hartu behar dituen klasea da.

# Abiaraztea
Behin abiarazten da eta datu berriak sartzerakoan bakarrik eguneratzen dira.


# Klase diagrama
![T4](https://user-images.githubusercontent.com/75114146/152747954-3e3174ec-3e54-4b37-ba0f-ae739c343ed0.svg)

# Iturriak
Aurreko ariketak <br/>
https://docs.mongodb.com/manual/reference/operator/query/
