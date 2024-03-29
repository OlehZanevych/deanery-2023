INSERT INTO faculties (id, name, website, email, phone, address)
VALUES (1, 'Біологічний', 'bioweb.lnu.edu.ua', 'biolog@lnu.edu.ua', '274-03-72, 239-41-53',
        'вул. Михайла Грушевського, 4, м. Львів, 79005'),
       (2, 'Географічний', 'geography.lnu.edu.ua', 'geodekanat@gmail.com', '239-41-62, 272-26-44',
        'вул. Дорошенка, 41, м. Львів, 79000'),
       (3, 'Геологічний', 'geology.lnu.edu.ua', 'decanat.geology@ukr.net', '261-60-56, 239-41-56',
        'вул. Михайла Грушевського, 4, м. Львів, 79005'),
       (4, 'Економічний', 'econom.lnu.edu.ua', 'edean@lnu.edu.ua', '239-41-68',
        'проспект Свободи, 18, м. Львів, 79008'),
       (5, 'Електроніки та комп''ютерних технологій', 'electronics.lnu.edu.ua', 'electronics.faculty@lnu.edu.ua',
        '261-14-91, 239-47-24, 239-41-82', 'вул. Драгоманова, 50, м. Львів, 79005'),
       (6, 'Журналістики', 'journ.lnu.edu.ua', 'journft@lnu.edu.ua', '239-47-51',
        'вул. Генерала Чупринки, 49, м. Львів, 79044'),
       (7, 'Іноземних мов', 'lingua.lnu.edu.ua', 'lingua.faculty@lnu.edu.ua', '239-47-16',
        'вул. Університетська 1/415, м. Львів, 79000'),
       (8, 'Історичний', 'clio.lnu.edu.ua', 'clio@lnu.edu.ua', '261-03-28', 'вул. Університетська, 1, м. Львів, 79000'),
       (9, 'Культури і мистецтв', 'kultart.lnu.edu.ua', 'fkultart@lnu.edu.ua', '239-41-97',
        'вул. Валова,18, м. Львів, 79008'),
       (10, 'Механіко-математичний', 'www.mmf.lnu.edu.ua', 'dmmf@lnu.edu.ua', '260-00-09, 239-41-74, 239-47-43',
        'вул. Університетська, 1 м. Львів, 79000'),
       (11, 'Міжнародних відносин', 'intrel.lnu.edu.ua', 'intrel.faculty@lnu.edu.ua', '255-43-17',
        'вул. Січових Стрільців, 19, м. Львів, 79000'),
       (12, 'Педагогічної освіти', 'pedagogy.lnu.edu.ua', 'pedosv.fakultet@ukr.net', '239-42-30',
        'вул. Туган-Барановського, 7, м. Львів, 79000'),
       (13, 'Прикладної математики та інформатики', 'ami.lnu.edu.ua', 'ami@lnu.edu.ua', '274-01-80, 239-41-86',
        'вул. Університетська 1, м. Львів, 79000'),
       (14, 'Управління фінансами та бізнесу', 'financial.lnu.edu.ua', 'financial.faculty@lnu.edu.ua',
        '235-64-50, 235-86-54', 'вул. Коперника, 3, м. Львів, 79000'),
       (15, 'Фізичний', 'physics.lnu.edu.ua', 'fiz_dekanat@lnu.edu.ua', '272-70-64',
        'вул. Кирила і Мефодія, 8, м. Львів, 79005'),
       (16, 'Філологічний', 'philology.lnu.edu.ua', 'filologylnu@gmail.com', '255-41-33, 239-41-58, 239-41-88',
        'вул. Університетська, 1, кімната 232, м. Львів, 79000'),
       (17, 'Філософський', 'filos.lnu.edu.ua', 'dfilos@lnu.edu.ua', '239-45-79',
        'вул. Університетська, 1, м. Львів, 79001'),
       (18, 'Хімічний', 'chem.lnu.edu.ua', 'chemdek@lnu.edu.ua', '260-03-91, 239-45-10',
        'вул. Кирила і Мефодія, 6, м. Львів, 79005'),
       (19, 'Юридичний', 'law.lnu.edu.ua', 'law.faculty@lnu.edu.ua', '239-41-02',
        'вул. Січових Стрільців, 14, м. Львів, 79000');
SELECT setval('faculties_id_seq', 19);

INSERT INTO departments (id, name, faculty_id, email, phone, info)
VALUES (1, 'Програмування', 13, 'programming.dep.ami@lnu.edu.ua', '(032) 239-41-78', 'Тестова інформація про кафедру'),
       (2, 'Інформаційних систем', 13, 'is.dep.ami@lnu.edu.ua', '(032) 239-45-45', 'Тестова інформація про кафедру'),
       (3, 'Дискретного аналізу та інтелектуальних систем', 13, 'kdais@lnu.edu.ua', '(032) 239-42-11',
        'Тестова інформація про кафедру'),
       (4, 'Обчислювальної математики', 13, 'cm.dep.ami@lnu.edu.ua', '(032) 239-43-91',
        'Тестова інформація про кафедру'),
       (5, 'Прикладної математики', 13, 'kpm@lnu.edu.ua', '(032) 239-41-78', 'Тестова інформація про кафедру'),
       (6, 'Теорії оптимальних процесів', 13, 'ktop@lnu.edu.ua', '(032) 239-47-91', 'Тестова інформація про кафедру'),
       (7, 'Математичного моделювання соціально-економічних процесів', 13, 'kafmmsep@lnu.edu.ua', '(032) 239-43-51',
        'Тестова інформація про кафедру');
SELECT setval('departments_id_seq', 7);

INSERT INTO users (username, password_hash, is_admin, first_name, middle_name, last_name, phone, email, info)
VALUES ('andriy100', '$2a$10$FIpjQDlCogT7evqJX7z.KOGVwnQTD1v4YK7G255OhlOdgMvjHjKYy', true, 'Andriy', 'Ivanovych', 'Burban', '+380673842378', 'Andriy.Burban@test', 'Fanny gay:)');
SELECT setval('users_id_seq', 1);