# ExportdataPostgre

# Helburua

Java programa hau, Json fitxategi bat irakurtzen du eta deskodifikatzen du, proiektu hau JPA erabili da eta klaseen mapeoa ere.
<br/>
Behin deskodifikatuta informazioa, objektu bat sortzen da eta Postgre eta Mongodb datubaseetara igotzen da.

*Config paketea*
1. HariZerbitzaria.java --> Harien klasea.
2. ImportConfig.java --> Importatzeko klasea da, hemen Hibernate sartzen da eta Context-a irakurtzen du.
3. Postgreconfig.java --> Hemen konexioa ezartzen da.

*eus.uni.dam*
1. HrEmployee.java --> Respartner bezalakoa da, baina, datu eremu berri bat dauka.
2. ManagementDAO.java --> DAO fitxategia.
3. PartidakPartidak.java --> Klase nagusia, non, ezartzen da partida bakoitza zer datu mota hartuko dituen.
4. Respartner.java --> Hremployee bezala da baina datuak mapeoan taula honetik hartzen ditu.


# Abiaraztea
Programa hau abiaraztean, beti entzuten jarraituko du eta hariak inplementatu dugunez "aldi berean" konekta daitezke pertsona desberdinak puntuazioa igotzeko.

# Klase diagrama

![ExportDataPostgre](https://user-images.githubusercontent.com/75113996/152750266-e32cd521-4041-415e-ae22-a58c78c1126f.svg)

# Iturriak
Aurreko ariketak
https://www.delftstack.com/es/howto/java/read-json-file-java/
https://pharos.sh/leer-y-escribir-json-en-java/
