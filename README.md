TASK 1
------

Create table towns

towns
* id: bigserial primary key
* name: text
* inhabitants_count: int

insert into the table rows:
'Warszawa' 200
'Wroclaw' 300
'Gdansk' 400
'Krakow' 500
'Opole' 600

select rows with inhabitant 400 <= count <= 650

TASK 2
------

Create notebook class, insert a few instances into db

Notebook
* model: String
* resolution: int
* productionTimestamp: Instant