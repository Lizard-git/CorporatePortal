-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.authority (description, name, shortname)
VALUES ('All access point', 'SuperAdmin', 'SuperAdmin');

INSERT INTO dashboard.authority (description, name, shortname)
VALUES ('Sequrity access point', 'SequrityDefault', 'Sequrity');

INSERT INTO dashboard.authority (description, name, shortname)
VALUES ('All access point', 'AdminDefault', 'Admin');

INSERT INTO dashboard.authority (description, name, shortname)
VALUES ('Access to all applications is closed, can only visit portal pages', 'UserDefault', 'User');

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.roles (description, name, shortname)
VALUES ('All access point', 'ROLE_SuperAdmin', 'SuperAdmin');

INSERT INTO dashboard.roles (description, name, shortname)
VALUES ('All access point', 'ROLE_AdminDefault', 'Admin');

INSERT INTO dashboard.roles (description, name, shortname)
VALUES ('All access point', 'ROLE_SequrityDefault', 'Sequrity');

INSERT INTO dashboard.roles (description, name, shortname)
VALUES ('Access to all applications is closed, can only visit portal pages', 'ROLE_UserDefault', 'User');

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.roles_authority(role_id, authority_id)
VALUES (
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_SuperAdmin'),
           (SELECT id from dashboard.authority as authorityes WHERE authorityes.name = 'SuperAdmin')
       );

INSERT INTO dashboard.roles_authority(role_id, authority_id)
VALUES (
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_UserDefault'),
           (SELECT id from dashboard.authority as authorityes WHERE authorityes.name = 'UserDefault')
       );

INSERT INTO dashboard.roles_authority(role_id, authority_id)
VALUES (
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_AdminDefault'),
           (SELECT id from dashboard.authority as authorityes WHERE authorityes.name = 'AdminDefault')
       );

INSERT INTO dashboard.roles_authority(role_id, authority_id)
VALUES (
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_SequrityDefault'),
           (SELECT id from dashboard.authority as authorityes WHERE authorityes.name = 'SequrityDefault')
       );
-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Административно-хозяйственный отдел (085-500-5028)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Бюджетный отдел (085-000-5534)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа капитального строительства и ремонта (085-500-5006)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа по взаимодействию со средствами массовой информации и связям с общественностью (085-000-5632)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа по охране труда (085-000-5573)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа по формированию средств пенсионных накоплений застрахованных лиц (085-430-4306)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа эксплуатации зданий № 1 (085-500-5019)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа эксплуатации зданий № 2 (085-500-5020)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Группа эксплуатации зданий № 3 (085-500-5021)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Акшинском районе (085-430-4331)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Александрово-Заводском районе (085-430-4315)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Балейском районе (085-430-4322)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Газимуро-Заводском районе (085-430-4323)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Каларском районе (085-430-4308)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Калганском районе (085-430-4318)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Красночикойском районе (085-430-4310)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Кыринском районе (085-430-4333)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Нерчинско-Заводском районе (085-430-4319)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Ононском районе (085-430-4336)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Тунгокоченском районе (085-430-4327)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах группы) в Шелопугинском районе (085-430-4329)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Агинском районе (085-430-4330)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Борзинском районе (085-430-4316)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в г. Краснокаменске и Краснокаменском районе (085-430-4314)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в г. Чите и Читинском районе (085-430-4307)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Дульдургинском районе (085-430-4332)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Забайкальском районе (085-430-4317)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Карымском районе (085-430-4309)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Могойтуйском районе (085-430-4334)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Могочинском и Тунгиро-Олекминском районах (085-430-4324)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Нерчинском районе (085-430-4325)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Оловянинском районе (085-430-4335)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Петровск-Забайкальском районе (085-430-4311)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Приаргунском районе (085-430-4320)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Сретенском районе (085-430-4326)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Улетовском районе (085-430-4312)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Хилокском районе (085-430-4313)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Чернышевском районе (085-430-4328)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Клиентская служба (на правах отдела) в Шилкинском районе (085-430-4321)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Контрольно-ревизионный отдел (085-000-5568)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Общий отдел (085-470-4701)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел администрирования страховых взносов (085-520-5811)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел аудита баз данных персонифицированного учета и страхователей (085-420-4272)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел ведения информационных данных и социальных регистров (085-410-4144)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №1 (085-420-4240)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №2 (085-420-4241)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №3 (085-420-4242)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел взаимодействия со страхователями №4 (085-420-4243)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел выплаты материнского (семейного) капитала (085-410-4146)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел выплаты пенсий и социальных выплат №1 (085-410-4104)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел выплаты пенсий и социальных выплат №2 (085-410-4105)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел дистанционного обслуживания клиентов (085-430-4303)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел кадров (085-000-5532)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел кассового исполнения бюджета № 1 (085-440-4413)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел кассового исполнения бюджета № 2 (085-440-4414)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля выплат (085-410-4160)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля установления мер социальной поддержки семьям с детьми (085-400-4021)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля установления пенсий (085-360-3673)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел контроля установления социальных выплат (085-380-3836)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел координации работы внешних организаций в государственных информационных системах (085-460-4607)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел назначения и осуществления страховых выплат застрахованным гражданам (085-540-5403)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел обеспечения закупок социального назначения (085-500-5032)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации взаимодействия со страхователями (085-420-4203)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации выплаты пенсий и социальных выплат (085-410-4101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации заблаговременной работы (085-360-3603)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации назначения и перерасчета пенсий (085-360-3601)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации персонифицированного учета (085-420-4201)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации работы клиентских служб (085-430-4301)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации социальных выплат (085-380-3801)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел организации установления выплат семьям с детьми (085-400-4001)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 1 (085-360-3702)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 2 (085-360-3703)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 3 (085-360-3704)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел оценки пенсионных прав застрахованных лиц и заблаговременной работы № 4 (085-360-3705)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел персонифицированного учета и обработки информации (085-420-4205)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по защите информации (085-000-5570)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по осуществлению закупок (085-500-5003)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по работе с обращениями граждан застрахованных лиц организаций и страхователей (085-470-4703)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по расчетам с дебиторами-кредиторами (085-440-4466)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по расчетам с физическими лицами и платежам в бюджет (085-440-4422)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по учету основных средств и материальных ценностей (085-440-4446)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел по формированию отчетности (085-440-4444)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел проверок (085-520-5201)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел регистрации страхователей и учета платежей (085-420-4270)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел социальных программ № 1 (085-510-5116)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел социальных программ № 2 (085-510-5117)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел страхования на случай временной нетрудоспособности и в связи с материнством (085-540-5401)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел страхования профессиональных рисков (085-520-5213)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления материнского (семейного) капитала №1 (085-380-3868)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления материнского (семейного) капитала №2 (085-380-3869)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 1 (085-400-4013)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 2 (085-400-4014)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 3 (085-400-4015)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления мер социальной поддержки семьям с детьми № 4 (085-400-4016)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №1 (085-360-3608)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №2 (085-360-3609)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №3 (085-360-3610)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления пенсий №4 (085-360-3611)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел установления социальных выплат (085-380-3803)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел эксплуатации зданий (085-500-5007)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел эксплуатации и сопровождения информационных подсистем (085-460-4601)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Отдел эксплуатации средств вычислительной техники программного обеспечения и телекоммуникационного оборудования (085-460-4603)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство отделения СФР (085-000-3500)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления выплаты пенсий и социальных выплат  (085-410-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления делами(085-470-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления информационных технологий (085-460-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления казначейства (085-440-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления материально-технического обеспечения (085-500-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления организации работы клиентских служб (085-430-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления организации страхования профессиональных рисков (085-520-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления организации страховых выплат (085-540-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления персонифицированного учета (085-420-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления реализации социальных программ (085-510-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления социального обеспечения семей с детьми (085-400-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления установления пенсий (085-360-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Руководство управления установления социальных выплат (085-380-0101)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Специалисты при руководстве (085-000-3502)');

INSERT INTO dashboard.departments (creationdate, description, name)
VALUES ('2022-07-26 00:40:30.000000', 'Отдел для', 'Юридический отдел (085-000-5566)');

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.address (city, frame, house, street)
VALUES ('г.Чита', null, '160Б', 'ул.Чкалова');

INSERT INTO dashboard.address (city, frame, house, street)
VALUES ('г.Чита', null, '160', 'ул.Чкалова');

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.position (name)
VALUES ('Администратор');

INSERT INTO dashboard.position (name)
VALUES ('Архивариус');

INSERT INTO dashboard.position (name)
VALUES ('Ведущий специалист - эксперт');

INSERT INTO dashboard.position (name)
VALUES ('Главный контролер - ревизор');

INSERT INTO dashboard.position (name)
VALUES ('Главный специалист - эксперт');

INSERT INTO dashboard.position (name)
VALUES ('Главный специалист-эксперт (по гражданской обороне)');

INSERT INTO dashboard.position (name)
VALUES ('Заведующий хозяйством');

INSERT INTO dashboard.position (name)
VALUES ('Заместитель начальника отдела');

INSERT INTO dashboard.position (name)
VALUES ('Заместитель начальника управления');

INSERT INTO dashboard.position (name)
VALUES ('Заместитель начальника управления – начальник отдела');

INSERT INTO dashboard.position (name)
VALUES ('Заместитель управляющего отделением');

INSERT INTO dashboard.position (name)
VALUES ('Консультант');

INSERT INTO dashboard.position (name)
VALUES ('Начальник отдела');

INSERT INTO dashboard.position (name)
VALUES ('Начальник управления');

INSERT INTO dashboard.position (name)
VALUES ('Начальник управления – главный бухгалтер');

INSERT INTO dashboard.position (name)
VALUES ('Помощник управляющего отделением');

INSERT INTO dashboard.position (name)
VALUES ('Руководитель группы');

INSERT INTO dashboard.position (name)
VALUES ('Руководитель клиентской службы (на правах группы)');

INSERT INTO dashboard.position (name)
VALUES ('Руководитель клиентской службы (на правах отдела)');

INSERT INTO dashboard.position (name)
VALUES ('Слесарь-сантехник 4 разряда');

INSERT INTO dashboard.position (name)
VALUES ('Специалист 1 разряда');

INSERT INTO dashboard.position (name)
VALUES ('Cпециалист - эксперт');

INSERT INTO dashboard.position (name)
VALUES ('Старший инспектор');

INSERT INTO dashboard.position (name)
VALUES ('Старший контролер-ревизор');

INSERT INTO dashboard.position (name)
VALUES ('Старший специалист');

INSERT INTO dashboard.position (name)
VALUES ('Управляющий отделением');

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.users (cabinetnumber, creationdate, datebirthday, deletedate, homeemail,
                             ipaddresspc, ipphone, isaccountnonexpired, isaccountnonlocked, iscredentialsnonexpired,
                             isenabled, lastmodifieddate, login, middlename, mobilephone, name, password, phone,
                             surname, workemail, idaddress, idddepartments, position)
VALUES ('27', '2023-05-29 17:28:23.000000', '1996-05-28 00:00:00.000000', null,
        'sanyok123128@gmail.com', '10.85.0.192', '4561', true, true, true, true, '2023-05-29 17:30:16.000000', 'Lizard',
        'Евгеньевич', '+79144551590', 'Александр', '$2a$12$2VDhsX0zfVscPXUuZqhUe.QAY3243G8sb94yhGDieyUpynKxNiRPm',
        '28 - 01 - 11', 'Орлов', 'orlovae@75.sfr.gov.ru', null, null, null);

INSERT INTO dashboard.users (cabinetnumber, creationdate, datebirthday, deletedate, homeemail,
                             ipaddresspc, ipphone, isaccountnonexpired, isaccountnonlocked, iscredentialsnonexpired,
                             isenabled, lastmodifieddate, login, middlename, mobilephone, name, password, phone,
                             surname, workemail, idaddress, idddepartments, position)
VALUES ('28', '2023-05-29 17:28:23.000000', '1983-07-31 00:00:00.000000', null,
        'test123128@gmail.com', '10.85.1.164', '4561', true, true, true, true, '2023-05-29 17:30:16.000000',
        'PodimalovaMN', 'Николаевна', '+79242794613', 'Марина',
        '$2a$12$2VDhsX0zfVscPXUuZqhUe.QAY3243G8sb94yhGDieyUpynKxNiRPm', '28 - 00 - 00', 'Подымалова',
        'podymalovamn@75.sfr.gov.ru', null, null, null);

INSERT INTO dashboard.users (cabinetnumber, creationdate, datebirthday, deletedate, homeemail,
                             ipaddresspc, ipphone, isaccountnonexpired, isaccountnonlocked, iscredentialsnonexpired,
                             isenabled, lastmodifieddate, login, middlename, mobilephone, name, password, phone,
                             surname, workemail, idaddress, idddepartments, position)
VALUES ('32', '2023-05-29 17:28:23.000000', '1983-07-31 00:00:00.000000', null,
        '1test123128@gmail.com', '10.85.1.165', '4581', true, true, true, true, '2023-05-29 17:30:16.000000',
        'OgnevYA', 'Андреевич', '+79144415710', 'Ярослав',
        '$2a$12$2VDhsX0zfVscPXUuZqhUe.QAY3243G8sb94yhGDieyUpynKxNiRPm', '28 - 00 - 00', 'Огнев',
        'ognevyaa@75.sfr.gov.ru', null, null, null);

INSERT INTO dashboard.users (cabinetnumber, creationdate, datebirthday, deletedate, homeemail,
                             ipaddresspc, ipphone, isaccountnonexpired, isaccountnonlocked, iscredentialsnonexpired,
                             isenabled, lastmodifieddate, login, middlename, mobilephone, name, password, phone,
                             surname, workemail, idaddress, idddepartments, position)
VALUES ('27', '2023-05-29 17:28:23.000000', '1983-07-31 00:00:00.000000', null,
        '2test123128@gmail.com', '10.85.1.161', '4561', true, true, true, true, '2023-05-29 17:30:16.000000',
        'MatveevaVA', 'Александровна', '+79243789108', 'Виктория',
        '$2a$12$2VDhsX0zfVscPXUuZqhUe.QAY3243G8sb94yhGDieyUpynKxNiRPm', '28 - 00 - 00', 'Матвеева',
        'strelnikovava@75.sfr.gov.ru', null, null, null);
-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.applicationstatus (description, statusname)
VALUES ('Приложение на стадии разработки', 'В разработке');

INSERT INTO dashboard.applicationstatus (description, statusname)
VALUES ('Приложение разработано, ожидает внедрения', 'Внедрение');

INSERT INTO dashboard.applicationstatus (description, statusname)
VALUES ('Штатная работа приложения', 'Работает');

INSERT INTO dashboard.applicationstatus (description, statusname)
VALUES ('Приложение находится на доработке', 'На доработке');

INSERT INTO dashboard.applicationstatus (description, statusname)
VALUES ('Приложение отключено', 'Отключено');

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.users_roles(user_id, role_id)
VALUES (
           (SELECT id from dashboard.users as users WHERE users.login = 'Lizard'),
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_SuperAdmin')
       );

INSERT INTO dashboard.users_roles(user_id, role_id)
VALUES (
           (SELECT id from dashboard.users as users WHERE users.login = 'PodimalovaMN'),
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_UserDefault')
       );

INSERT INTO dashboard.users_roles(user_id, role_id)
VALUES (
           (SELECT id from dashboard.users as users WHERE users.login = 'OgnevYA'),
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_UserDefault')
       );

INSERT INTO dashboard.users_roles(user_id, role_id)
VALUES (
           (SELECT id from dashboard.users as users WHERE users.login = 'MatveevaVA'),
           (SELECT id from dashboard.roles as rolse WHERE rolse.name = 'ROLE_UserDefault')
       );

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --
UPDATE dashboard.users
SET idddepartments=(SELECT id FROM dashboard.departments as dep WHERE dep.name = 'Отдел эксплуатации и сопровождения информационных подсистем (085-460-4601)')
WHERE login='Lizard';

UPDATE dashboard.users
SET idddepartments=(SELECT id FROM dashboard.departments as dep WHERE dep.name = 'Отдел эксплуатации и сопровождения информационных подсистем (085-460-4601)')
WHERE login='PodimalovaMN';

UPDATE dashboard.users
SET idddepartments=(SELECT id FROM dashboard.departments as dep WHERE dep.name = 'Отдел эксплуатации и сопровождения информационных подсистем (085-460-4601)')
WHERE login='MatveevaVA';

UPDATE dashboard.users
SET idddepartments=(SELECT id FROM dashboard.departments as dep WHERE dep.name = 'Отдел эксплуатации средств вычислительной техники программного обеспечения и телекоммуникационного оборудования (085-460-4603)')
WHERE login='OgnevYA';
-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

UPDATE dashboard.users
SET "position"=(SELECT id FROM dashboard."position" as pos WHERE pos.name = 'Ведущий специалист - эксперт')
WHERE login='Lizard';

UPDATE dashboard.users
SET "position"=(SELECT id FROM dashboard."position" as pos WHERE pos.name = 'Начальник управления')
WHERE login='PodimalovaMN';

UPDATE dashboard.users
SET "position"=(SELECT id FROM dashboard."position" as pos WHERE pos.name = 'Ведущий специалист - эксперт')
WHERE login='MatveevaVA';

UPDATE dashboard.users
SET "position"=(SELECT id FROM dashboard."position" as pos WHERE pos.name = 'Cпециалист - эксперт')
WHERE login='OgnevYA';

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

UPDATE dashboard.users
SET idaddress = (
    SELECT id FROM dashboard.address as address WHERE
            address.city = 'г.Чита' and
            address.street = 'ул.Чкалова' and
            address.house = '160Б'
)
WHERE login='Lizard';

UPDATE dashboard.users
SET idaddress = (
    SELECT id FROM dashboard.address as address WHERE
            address.city = 'г.Чита' and
            address.street = 'ул.Чкалова' and
            address.house = '160Б'
)
WHERE login='PodimalovaMN';

UPDATE dashboard.users
SET idaddress = (
    SELECT id FROM dashboard.address as address WHERE
            address.city = 'г.Чита' and
            address.street = 'ул.Чкалова' and
            address.house = '160Б'
)
WHERE login='OgnevYA';

UPDATE dashboard.users
SET idaddress = (
    SELECT id FROM dashboard.address as address WHERE
            address.city = 'г.Чита' and
            address.street = 'ул.Чкалова' and
            address.house = '160Б'
)
WHERE login='MatveevaVA';

-- --------------------------------------------------------------------------------------------------------------- --

-- --------------------------------------------------------------------------------------------------------------- --

INSERT INTO dashboard.filesstatus (description, statusname)
VALUES ('Доступный всем пользователям', 'Общедоступный');

INSERT INTO dashboard.filesstatus (description, statusname)
VALUES ('Доступный пользователям у котрых есть ссылка на загрузку этого файла', 'Доступ по ссылке');

-- --------------------------------------------------------------------------------------------------------------- --

