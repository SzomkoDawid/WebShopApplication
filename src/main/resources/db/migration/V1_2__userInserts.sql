INSERT INTO addresses(id, country, city, street, post_code)
values (1, 'Polska', 'Białystok', 'Pogodna 3/45', '15-354');
INSERT INTO addresses(id, country, city, street, post_code)
values (2, 'Polska', 'Hajnówka', 'Piwna 2/25', '16-549');
INSERT INTO addresses(id, country, city, street, post_code)
values (3, 'Polska', 'Warszawa', 'Poznańska 10/99', '22-241');

INSERT INTO roles(id, role)
values (1, 'ADMIN');
INSERT INTO roles(id, role)
values (2, 'USER');

INSERT INTO users(address_id, role_id, login, password, e_mail, avatar_url, first_name, last_name)
values (1,1, 'dawid94', 'password', 'dawid-100@wp.pl',
'https://pickaface.net/gallery/avatar/tommtraps56cc2f44d17a5.png', 'Dawid', 'Szomko');
INSERT INTO users(address_id, role_id, login, password, e_mail, avatar_url, first_name, last_name)
values (2, 1, 'dymu93', 'password', 'damian.wawreszuk@gmail.com',
'https://pickaface.net/gallery/avatar/unr_standard_180203_0234_y7cln.png', 'Damian', 'Wawreszuk');
INSERT INTO users(address_id, role_id, login, password, e_mail, avatar_url, first_name, last_name)
values (3, 2, 'rudolf', 'password', 'rudolf@o2.pl', 'https://www.colourbox.com/preview/7439411-rudolf.jpg',
'Andrzej', 'Rudolf');
