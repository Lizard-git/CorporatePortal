INSERT INTO dashboard.authority (id, description, name, shortname)
VALUES (1, 'All access point', 'SuperAdmin', 'SuperAdmin');

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.roles (id, description, name, shortname)
VALUES (1, 'All access point', 'ROLE_SuperAdmin', 'SuperAdmin');

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.roles_authority (role_id, authority_id)
VALUES (1, 1);

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (1, '2022-07-26 00:40:30.000000', 'IT Отдел', 'Отдел эксплуатации и сопровождения информационных подсистем');

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.address (id, city, frame, house, street)
VALUES (1, 'г.Чита', null, '160Б', 'ул.Чкалова');

INSERT INTO dashboard.address (id, city, frame, house, street)
VALUES (2, 'г.Чита', null, '160', 'ул.Чкалова');

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.position (id, name)
VALUES (1, 'Начальник управления информационных технологий');

INSERT INTO dashboard.position (id, name)
VALUES (2, 'Главный специалист');

INSERT INTO dashboard.position (id, name)
VALUES (3, 'Ведущий специалист - эксперт');

INSERT INTO dashboard.position (id, name)
VALUES (4, 'Cпециалист - эксперт');


-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.datauser (id, cabinetnumber, datebirthday, dateexperience, homeemail, ipaddresspc, ipphone,
                                middlename, mobilephone, name, phone, surname, workemail, idddepartments, idaddress,
                                position)
VALUES (1, '28', '2022-07-26 00:40:30.000000', '2021-06-26 00:40:39.000000', 'test@gmail.com', '10.85.0.19', '1234', 'Николаевна', '+7 (914) 999-99-99', 'Марина', '99 - 99 - 99', 'Подымалова', 'test@75.sfr.gov.ru', 1, 1, 1);

INSERT INTO dashboard.datauser (id, cabinetnumber, datebirthday, dateexperience, homeemail, ipaddresspc, ipphone,
                                middlename, mobilephone, name, phone, surname, workemail, idddepartments, idaddress,
                                position)
VALUES (2, '27', '2022-07-26 00:40:30.000000', '2021-06-26 00:40:39.000000', 'sanyok123128@gmail.com', '10.85.0.18', '1234', 'Евгеньевич', '+7 (914) 455-15-90', 'Александр', '28 - 05 - 95', 'Орлов', 'orlovae@75.sfr.gov.ru', 1, 1, 3);

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.users (id, creationdate, deletedate, isaccountnonexpired, isaccountnonlocked,
                             iscredentialsnonexpired, isenabled, lastmodifieddate, login, password, datauser)
VALUES (DEFAULT, '2023-04-26 16:49:22.000000', null, true, true, true, true, '2023-04-26 16:49:33.000000', 'PodimalovaMN', '$2a$12$2VDhsX0zfVscPXUuZqhUe.QAY3243G8sb94yhGDieyUpynKxNiRPm', 1);

INSERT INTO dashboard.users (id, creationdate, deletedate, isaccountnonexpired, isaccountnonlocked,
                             iscredentialsnonexpired, isenabled, lastmodifieddate, login, password, datauser)
VALUES (DEFAULT, '2023-04-26 16:49:22.000000', null, true, true, true, true, '2023-04-26 16:49:33.000000', 'Lizard', '$2a$12$2VDhsX0zfVscPXUuZqhUe.QAY3243G8sb94yhGDieyUpynKxNiRPm', 2);

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO dashboard.users_roles (user_id, role_id)
VALUES (2, 1);
-- --------------------------------------------------------------------------------------------------------------- --