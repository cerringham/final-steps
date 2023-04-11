Il progetto FinalSteps è una Java web application che sfrutta un database in memoria H2.
Il progetto è strutturato come una web application che espone servizi REST.
Il progetto prevede due metodi dentro ad una classe CityController:
- il primo metodo che permette l'inserimento di una city
- il secondo che fa l'elenco di tutte le city
Il primo metodo contiene degli errori logici e anche degli errori relativi alla sintassi (nomi delle variabili),
trovare questi errori e correggerli. 

Raffinare il metodo di inserimento aggiungendo le validazioni che ritenete opportune. 

Creare una classe di test per il servizio, quali sono i casi di test da inserire?
Sicuramente il caso positivo di ogni servizio: un inserimento riuscito bene e un elenco di ciy non vuoto.
Ma per essere sicuri che il nostro programma non abbia dei side effects allora occorre anche creare dei casi di test 
negativi, quali?
- inserimento con un body vuoto, cosa risponde il servizio?
- inserimento con un body incompleto, cosa risponde il servizio?
- inserimento di dati con lo stesso id, cosa risponde il servizio?
- e via dicendo ...

Creare nel file schema.sql lo script sql per modellare una tabella Citizen che contiene un cittadino. 
I dati da memorizzare sono id, name, surname, birthdate, fiscal_code, address, id_number (carta di identità)
Creare i servizi CRUD per inserire, cancellare, modificare e fare l'elenco di tutti i cittadini o per iniziale del cognome.
Creare tutti i casi di test necessari. 
