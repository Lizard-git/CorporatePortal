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
VALUES (1, '2022-07-26 00:40:30.000000', 'Отдел для', 'Административно-хозяйственный отдел (085-500-5028)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (2, '2022-07-26 00:40:30.000000', 'Отдел для', 'Бюджетный отдел (085-000-5534)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (3, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа капитального строительства и ремонта (085-500-5006)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (4, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа по взаимодействию со средствами массовой информации и связям с общественностью (085-000-5632)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (5, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа по охране труда (085-000-5573)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (6, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа по формированию средств пенсионных накоплений застрахованных лиц (085-430-4306)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (7, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа эксплуатации зданий № 1 (085-500-5019)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (8, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа эксплуатации зданий № 2 (085-500-5020)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (9, '2022-07-26 00:40:30.000000', 'Отдел для', 'Группа эксплуатации зданий № 3 (085-500-5021)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (10, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Акшинском районе (085-430-4331)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (11, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Александрово-Заводском районе (085-430-4315)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (12, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Балейском районе (085-430-4322)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (13, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Газимуро-Заводском районе (085-430-4323)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (14, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Каларском районе (085-430-4308)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (15, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Калганском районе (085-430-4318)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (16, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Красночикойском районе (085-430-4310)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (17, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Кыринском районе (085-430-4333)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (18, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Нерчинско-Заводском районе (085-430-4319)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (19, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Ононском районе (085-430-4336)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (20, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Тунгокоченском районе (085-430-4327)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (21, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Шелопугинском районе (085-430-4329)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (22, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Агинском районе (085-430-4330)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (23, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Борзинском районе (085-430-4316)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (24, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в г. Краснокаменске и Краснокаменском районе (085-430-4314)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (25, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в г. Чите и Читинском районе (085-430-4307)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (26, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Дульдургинском районе (085-430-4332)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (27, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Забайкальском районе (085-430-4317)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (28, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Карымском районе (085-430-4309)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (29, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Могойтуйском районе (085-430-4334)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (30, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Могочинском и Тунгиро-Олекминском районах (085-430-4324)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (31, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Нерчинском районе (085-430-4325)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (32, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Оловянинском районе (085-430-4335)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (33, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Петровск-Забайкальском районе (085-430-4311)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (34, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Приаргунском районе (085-430-4320)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (35, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Сретенском районе (085-430-4326)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (36, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Улетовском районе (085-430-4312)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (37, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Хилокском районе (085-430-4313)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (38, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Чернышевском районе (085-430-4328)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (39, '2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Шилкинском районе (085-430-4321)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (40, '2022-07-26 00:40:30.000000', 'Отдел для', 'Контрольно-ревизионный отдел (085-000-5568)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (41, '2022-07-26 00:40:30.000000', 'Отдел для', 'Общий отдел (085-470-4701)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (42, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел администрирования страховых взносов (085-520-5811)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (43, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел аудита баз данных персонифицированного учета и страхователей (085-420-4272)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (44, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел ведения информационных данных и социальных регистров (085-410-4144)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (45, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №1 (085-420-4240)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (46, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №2 (085-420-4241)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (47, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №3 (085-420-4242)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (48, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №4 (085-420-4243)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (49, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел выплаты материнского (семейного) капитала (085-410-4146)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (50, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел выплаты пенсий и социальных выплат №1 (085-410-4104)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (51, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел выплаты пенсий и социальных выплат №2 (085-410-4105)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (52, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел дистанционного обслуживания клиентов (085-430-4303)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (53, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел кадров (085-000-5532)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (54, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел кассового исполнения бюджета № 1 (085-440-4413)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (55, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел кассового исполнения бюджета № 2 (085-440-4414)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (56, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля выплат (085-410-4160)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (57, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля установления мер социальной поддержки семьям с детьми (085-400-4021)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (58, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля установления пенсий (085-360-3673)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (59, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля установления социальных выплат (085-380-3836)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (60, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел координации работы внешних организаций в государственных информационных системах (085-460-4607)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (61, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел назначения и осуществления страховых выплат застрахованным гражданам (085-540-5403)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (62, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел обеспечения закупок социального назначения (085-500-5032)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (63, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации взаимодействия со страхователями (085-420-4203)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (64, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации выплаты пенсий и социальных выплат (085-410-4101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (65, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации заблаговременной работы (085-360-3603)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (66, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации назначения и перерасчета пенсий (085-360-3601)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (67, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации персонифицированного учета (085-420-4201)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (68, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации работы клиентских служб (085-430-4301)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (69, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации социальных выплат (085-380-3801)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (70, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации установления выплат семьям с детьми (085-400-4001)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (71, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 1 (085-360-3702)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (72, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 2 (085-360-3703)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (73, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 3 (085-360-3704)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (74, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 4 (085-360-3705)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (75, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел персонифицированного учета и обработки информации (085-420-4205)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (76, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по защите информации (085-000-5570)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (77, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по осуществлению закупок (085-500-5003)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (78, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по работе с обращениями граждан застрахованных лиц организаций и страхователей (085-470-4703)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (79, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по расчетам с дебиторами-кредиторами (085-440-4466)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (80, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по расчетам с физическими лицами и платежам в бюджет (085-440-4422)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (81, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по учету основных средств и материальных ценностей (085-440-4446)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (82, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по формированию отчетности (085-440-4444)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (83, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел проверок (085-520-5201)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (84, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел регистрации страхователей и учета платежей (085-420-4270)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (85, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел социальных программ № 1 (085-510-5116)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (86, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел социальных программ № 2 (085-510-5117)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (87, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел страхования на случай временной нетрудоспособности и в связи с материнством (085-540-5401)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (88, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел страхования профессиональных рисков (085-520-5213)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (89, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления материнского (семейного) капитала №1 (085-380-3868)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (90, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления материнского (семейного) капитала №2 (085-380-3869)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (91, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 1 (085-400-4013)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (92, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 2 (085-400-4014)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (93, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 3 (085-400-4015)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (94, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 4 (085-400-4016)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (95, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №1 (085-360-3608)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (96, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №2 (085-360-3609)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (97, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №3 (085-360-3610)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (98, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №4 (085-360-3611)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (99, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления социальных выплат (085-380-3803)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (100, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел эксплуатации зданий (085-500-5007)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (101, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел эксплуатации и сопровождения информационных подсистем (085-460-4601)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (102, '2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел эксплуатации средств вычислительной техники программного обеспечения и телекоммуникационного оборудования (085-460-4603)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (103, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство отделения СФР (085-000-3500)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (104, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления выплаты пенсий и социальных выплат  (085-410-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (105, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления делами(085-470-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (106, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления информационных технологий (085-460-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (107, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления казначейства (085-440-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (108, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления материально-технического обеспечения (085-500-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (109, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления организации работы клиентских служб (085-430-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (110, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления организации страхования профессиональных рисков (085-520-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (111, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления организации страховых выплат (085-540-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (112, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления персонифицированного учета (085-420-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (113, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления реализации социальных программ (085-510-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (114, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления социального обеспечения семей с детьми (085-400-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (115, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления установления пенсий (085-360-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (116, '2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления установления социальных выплат (085-380-0101)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (117, '2022-07-26 00:40:30.000000', 'Отдел для', 'Специалисты при руководстве (085-000-3502)');

INSERT INTO dashboard.departments (id, creationdate, description, name)
VALUES (118, '2022-07-26 00:40:30.000000', 'Отдел для', 'Юридический отдел (085-000-5566)');



-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.address (id, city, frame, house, street)
VALUES (1, 'г.Чита', null, '160Б', 'ул.Чкалова');

INSERT INTO dashboard.address (id, city, frame, house, street)
VALUES (2, 'г.Чита', null, '160', 'ул.Чкалова');

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.position (id, name)
VALUES (1, 'Администратор');

INSERT INTO dashboard.position (id, name)
VALUES (2, 'Архивариус');

INSERT INTO dashboard.position (id, name)
VALUES (3, 'Ведущий специалист - эксперт');

INSERT INTO dashboard.position (id, name)
VALUES (4, 'Главный контролер - ревизор');

INSERT INTO dashboard.position (id, name)
VALUES (5, 'Главный специалист - эксперт');

INSERT INTO dashboard.position (id, name)
VALUES (6, 'Главный специалист-эксперт (по гражданской обороне)');

INSERT INTO dashboard.position (id, name)
VALUES (7, 'Заведующий хозяйством');

INSERT INTO dashboard.position (id, name)
VALUES (8, 'Заместитель начальника отдела');

INSERT INTO dashboard.position (id, name)
VALUES (9, 'Заместитель начальника управления');

INSERT INTO dashboard.position (id, name)
VALUES (10, 'Заместитель начальника управления – начальник отдела');

INSERT INTO dashboard.position (id, name)
VALUES (11, 'Заместитель управляющего отделением');

INSERT INTO dashboard.position (id, name)
VALUES (12, 'Консультант');

INSERT INTO dashboard.position (id, name)
VALUES (13, 'Начальник отдела');

INSERT INTO dashboard.position (id, name)
VALUES (14, 'Начальник управления');

INSERT INTO dashboard.position (id, name)
VALUES (15, 'Начальник управления – главный бухгалтер');

INSERT INTO dashboard.position (id, name)
VALUES (16, 'Помощник управляющего отделением');

INSERT INTO dashboard.position (id, name)
VALUES (17, 'Руководитель группы');

INSERT INTO dashboard.position (id, name)
VALUES (18, 'Руководитель клиентской службы (на правах группы)');

INSERT INTO dashboard.position (id, name)
VALUES (19, 'Руководитель клиентской службы (на правах отдела)');

INSERT INTO dashboard.position (id, name)
VALUES (21, 'Слесарь-сантехник 4 разряда');

INSERT INTO dashboard.position (id, name)
VALUES (22, 'Специалист 1 разряда');

INSERT INTO dashboard.position (id, name)
VALUES (23, 'Cпециалист - эксперт');

INSERT INTO dashboard.position (id, name)
VALUES (24, 'Старший инспектор');

INSERT INTO dashboard.position (id, name)
VALUES (25, 'Старший контролер-ревизор');

INSERT INTO dashboard.position (id, name)
VALUES (26, 'Старший специалист');

INSERT INTO dashboard.position (id, name)
VALUES (27, 'Управляющий отделением');

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