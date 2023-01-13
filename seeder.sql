USE wanderful_db;

INSERT INTO users (user_password, user_name, first_name, last_name, school, email)
VALUES ('$2a$12$L.Ul1ZMJTbZQSwv8ZdQPjedyrn537Y63IYyEbbytA.8kMK/mQ1VPa', 'PWizzi', 'Penny', 'Raker', 'CatLyfe', 'Penn2Cool@catmail.com'),
       ('$2a$12$0IxG5XLrgA.E8Su354yqPeC5O.dzxl3qYT3j98.JxY.1mTfBr4/Gy', 'Milesy', 'Miles', 'Raker', '24th Grade', 'MilesRaker@gmail.com'),
       ('$2a$12$9ze1qVbsNY9NxBavlPgqFeMLYFWRPNAXjHtUNOcbCwNGTqAinMWZ2', 'PWizzWizz', 'Penny', 'Raker', 'Cattttttt', 'PWizDaWizard@magicCat.com'),
       ('$2a$10$LivElw2jqDtrqmMFpAVyveiBPBU4uKbOOStgZAM56Y1fxETi95A7u', 'Joany', 'Joan', 'Raker', 'PWizz Academy', 'Joanster@mew.com');

INSERT INTO wands (wand_name, core_material, wood_type, use_category, age, image, user_id)
VALUES ('Wand of Incremental Achievement', 'sweat of bees', 'pine', 'progression', 1, '', 2),
       ('Wand of Seaquest Park', 'red headed ranger hair', 'pine', 'lumberjacking', 1, '', 2),
       ('Staff of the Javanaut', 'essence of cmd+z', 'pine', 'sanity', 1, '', 2),
       ('Wand of the Unworthy', 'tears of enemies', 'ebony', 'hexes', 23, '', 4),
       ('Wand of Epic Job Placement', 'command key from overheated Macbook', 'decomposing cat limb', 'appeasing interviewers', 32, '', 1);

INSERT INTO ads (creation_date, ad_title, ad_description)
VALUES (2023-01-10, 'Wand of Incremental Achievement', 'This wand is designed to accentuate even the smallest incremental improvements made by your actions. Rejoice in knowing you are making progress, even slow progress counts.'),
       (2023-01-10, 'Wand of Seaquest Park', 'This wand''s material was sourced from Seaquest park in Castle Rock Washington. It embodies the lumberjack''s whiskey flavored heart. Lumberjack approved.'),
       (2023-01-11, 'Bring Sanity back!', 'The Staff of the Javanaut is specially designed to bring sanity back to Codeup graduates after being thoroughly swirled by Java III'),
       (2023-01-12, 'Got Enemies? I can help', 'Wand of the Unworthy was built by a nefarious cat with a penchant for hexes and blank stares.'),
       (2023-01-13, 'Job Hunters Click Here!', 'This Wand of Epic Job Placement is able to apparate Google and Amazon recruiters to your living room');

INSERT INTO wand_ads
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);