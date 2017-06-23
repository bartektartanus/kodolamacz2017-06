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

TASK 3
------

Create town class
Add town field to User, create one to one relationship

Town
* name
* inhabitantsCount

TASK 4
------

Create building class
Add users field to Building, create one to many relationship

Building
* address
* users

TASK 5
------

Create below model, insert some data to database, review created schema

Wallet
* amount
* owner: Customer - one-one

Customer
* name
* age
* cars - one-many

Car
* model: String

Shop
* name: String
* products: List<Product> - many-many

Product
* price
* name