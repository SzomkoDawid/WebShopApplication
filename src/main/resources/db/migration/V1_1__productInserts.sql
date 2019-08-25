INSERT INTO authors (id, name)
values (1, 'J.R.R Tolkien');
INSERT INTO authors (id, name)
values (2, 'J.K Rowling');
INSERT INTO authors (id, name)
values (3, 'Stephen King');
INSERT INTO authors (id, name)
values (4, 'James Joyce');
INSERT INTO authors (id, name)
values (5, 'Blanka Lipińska');
INSERT INTO authors (id, name)
values (6, 'Camilla Lackberg');
INSERT INTO authors (id, name)
values (7, 'David Lagerkrantz');
INSERT INTO authors (id, name)
values (8, 'Janusz Christa');
INSERT INTO authors (id, name)
values (9, 'Paweł Hładun');
INSERT INTO category (id, types_of_category)
values (1, 1);
INSERT INTO category (id, types_of_category)
values (2, 2);
INSERT INTO category (id, types_of_category)
values (3, 3);
INSERT INTO category (id, types_of_category)
values (4, 4);
INSERT INTO category (id, types_of_category)
values (5, 5);
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (1,1, 'Władca Pierścieni: Dwie Wieże', '1954, wydawca: Allen&Unwin', 49.99, 1, 50,
'https://assets.upflix.pl/media/plakat/2002/the-lord-of-the-rings-the-two-towers__300_427.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (2,1, 'Harry Potter i Komnata Tajemnic', '1988 , wydawca: Bloomsbery', 37.99, 1, 46,
'https://image.ceneostatic.pl/data/products/46228652/i-harry-potter-i-komnata-tajemnic.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (3, 3, 'Przebudzenie', '2017, wydawca: Greatbook', 32.99, 2, 32,
'https://cf2-taniaksiazka.statiki.pl/images/large/183/9788380692251.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (4, 1, 'Ulissess', '1922, wydawca: Sylwia Beach', 45.99, 5, 28,
'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/UlyssesCover.jpg/282px-UlyssesCover.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (5, 2, '365 dni', '2018, wydawca: Edipress', 22.99, 7, 57,
'https://files.legimi.com/images/46ab0c58d59090efb26d7605e960a7c3/w200_u90.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (6, 2, 'Złota klatka', '2019, wydawca: Black Ship', 49.99, 4, 57,
'https://cf2-taniaksiazka.statiki.pl/images/large/FC2/9788381430258.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (7, 3, 'Ja Ibra', '2012, wydawca: Mellino', 39.99, 3, 38,
'https://resources.kfi.pl/image/6353976e-60b2-41e0-be08-d4b3fb11127e/550x400/png');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (8, 5, 'Kajko i Kokosz - szkoła latania', '2018, wydawca: Dobra Książka', 12.99, 6, 22,
'https://ecsmedia.pl/c/15248061947814548-jpg-gallery.big-iext52856194.jpg');
INSERT INTO products (author_id, category_id, name, description, price, product_type, stock_amount, picture_url)
values (9, 4, 'W Polityce', '2019, wydawca: tygodnik Angora', 4.99, 6, 11,
'http://kultura.trzebiatow.pl/wp-content/uploads/Angora-e1453897403212.jpg');







