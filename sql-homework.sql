CREATE TABLE IF NOT EXISTS Country(
	countryCode varchar(10) PRIMARY KEY,
    CountryName varchar(50),
    continent varchar(10),
    surfaceArea double,
    population double,
    gnp double,
	capital int
);


INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('84', 'Viet Nam', 'AS', '329310', '97338579', '255.4', '2');
INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('86', 'China', 'AS', '9600000', '	1439323776', '14620', '15');
INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('1', 'USA', 'NA', '9630000', '331002651', '21290', '39');
INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('353', 'Ireland', 'EU', '70270', '14393276', '324.1', '45');
INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('53', 'Cuba', 'SA', '110860', '	11326616', '105.9', '43');
INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('7', 'Russia', 'AS EU', '17100000', '145934462', '1400', '46');
INSERT INTO `new_schema`.`Country` (`countryCode`, `CountryName`, `continent`, `surfaceArea`, `population`, `gnp`, `capital`) VALUES ('420', 'Czech', 'EU', '78870', '10708981', '236.8', '44');


CREATE TABLE IF NOT EXISTS City(
	id int PRIMARY KEY,
    cityName varchar(50),
    population double,
    countryCode varchar(10),
    FOREIGN KEY (countryCode) REFERENCES Country(countryCode)
);


INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('2', 'Ha Noi', '8.25', '84');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('21', 'Hai Duong', '0.5', '84');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('28', 'Thanh Hoa', '3.64', '84');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('29', 'Nghe An', '3.54', '84');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('30', 'Ha Tinh', '1.3', '84');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('3', 'Hai Phong', '2', '84');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('37', 'Los Angeles', '3.8', '1');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('38', 'Chicago', '2.6', '1');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('39', 'Washington DC', '0.67', '1');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('15', 'Beijing', '21.89', '86');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('16', 'Shanghai', '24.87', '86');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('17', 'Chongqing', '31', '86');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('18', 'Guangzhou', '18.68', '86');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('22', 'Chengdu', '20.93', '86');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('44', 'Prague', '1.275', '420');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('45', 'Dublin', '0.554', '353');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('46', 'Moscow', '12.655', '7');
INSERT INTO `new_schema`.`City` (`id`, `cityName`, `population`, `countryCode`) VALUES ('43', 'Havana', '11.33', '53');


ALTER TABLE Country ADD CONSTRAINT FOREIGN KEY (capital) REFERENCES City(id);

-- Câu 1
select cityName, countryCode x from City
group by cityName, x, population
having population >= all(select population from City where countryCode = x);

-- Câu 2
-- C1. 

SELECT cityName, continent c
from City inner join Country
on City.countryCode = Country.countryCode
group by cityName, continent, City.population
having City.population >= all(select City.population from City inner join Country on City.countryCode = Country.countryCode where continent = c);

-- C2.
with tmp as (
SELECT cityName, City.population, continent
FROM City inner join Country
on City.countryCode = Country.countryCode
)
select cityName, continent c
from tmp
group by continent, cityName, population
having population >= all(select population from view_city_country where continent = c);


-- Câu 3
select City.cityName
from City inner join Country
on Country.capital = City.id 
order by City.population DESC LIMIT 1;

-- Câu 4
select City.cityName, continent c
from City inner join Country
on Country.capital = City.id
group by continent, City.cityName, City.population
having City.population >= all(select City.population from City inner join Country on Country.capital  = City.id where continent = c);

-- Câu 5
Select countryName, count(*) numberOfCity
from Country inner join City
on Country.countryCode = City.countryCode
group by countryName
order by count(*) desc;

-- Câu 6
Select countryName
from Country
where population != 0
order by population desc