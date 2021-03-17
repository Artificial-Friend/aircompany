create table air_companies
(
    id         bigint auto_increment
        primary key,
    founded_at date         null,
    name       varchar(255) null,
    type       varchar(255) null,
    constraint UK_hiqexqpqm1sndbu6it33566u3
        unique (name)
);

INSERT INTO db.air_companies (id, founded_at, name, type) VALUES (1, '1994-01-03', 'aircompany1', 'LCC');
INSERT INTO db.air_companies (id, founded_at, name, type) VALUES (2, '2000-12-31', 'aircompany2', 'NETWORK');
INSERT INTO db.air_companies (id, founded_at, name, type) VALUES (3, '2020-11-13', 'aircompany3', 'ULCC');

create table airplanes
(
    id                bigint auto_increment
        primary key,
    created_at        date         null,
    flight_distance   bigint       null,
    fuel_capacity     int          null,
    name              varchar(255) null,
    number_of_flights int          null,
    serial_number     varchar(255) null,
    type              varchar(255) null,
    company_id        bigint       null,
    constraint UK_a4byftgs5orimok1a6uwty4b3
        unique (serial_number),
    constraint FKling2h1i5a6sro92i6q7d3546
        foreign key (company_id) references air_companies (id)
);

INSERT INTO db.airplanes (id, created_at, flight_distance, fuel_capacity, name, number_of_flights, serial_number, type, company_id) VALUES (1, '2010-01-05', 65537, 50000, 'Bob', 0, 'A13B-C8', 'HEAVY', 1);
INSERT INTO db.airplanes (id, created_at, flight_distance, fuel_capacity, name, number_of_flights, serial_number, type, company_id) VALUES (2, '2015-06-05', 18000, 5000, 'Alice', 5, 'B75P-C2', 'LIGHT', 2);
INSERT INTO db.airplanes (id, created_at, flight_distance, fuel_capacity, name, number_of_flights, serial_number, type, company_id) VALUES (3, '2016-07-07', 33000, 30000, 'John', 200, 'A66C-CL', 'MEDIUM', 3);

create table flights
(
    id                    bigint auto_increment
        primary key,
    created_at            datetime     null,
    delay_started_at      datetime     null,
    departure_country     varchar(255) null,
    destination_country   varchar(255) null,
    distance              smallint     not null,
    ended_at              datetime     null,
    estimated_flight_time time         null,
    status                varchar(255) null,
    airplane_id           bigint       null,
    company_id            bigint       null,
    constraint FK5htavipjc01da4i1yvbmoqhgf
        foreign key (company_id) references air_companies (id),
    constraint FKg5m8ip0f64g1nm42q8bf6s5ak
        foreign key (airplane_id) references airplanes (id)
);

INSERT INTO db.flights (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, status, airplane_id, company_id) VALUES (1, null, null, 'Ukraine', 'Ukraine', 3000, null, '02:10:00', 'PENDING', 1, 1);
INSERT INTO db.flights (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, status, airplane_id, company_id) VALUES (2, '2021-03-11 11:38:28', null, 'Ukraine', 'Ukraine', 2500, null, '01:35:00', 'ACTIVE', 2, 2);
INSERT INTO db.flights (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, status, airplane_id, company_id) VALUES (3, '2021-03-11 11:38:28', null, 'Ukraine', 'Ukraine', 1000, '2021-03-11 12:38:28', '01:00:00', 'COMPLETED', 3, 3);
INSERT INTO db.flights (id, created_at, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, status, airplane_id, company_id) VALUES (4, null, '2021-03-11 12:38:28', 'Ukraine', 'Ukraine', 500, null, '00:30:00', 'DELAYED', 3, 3);
