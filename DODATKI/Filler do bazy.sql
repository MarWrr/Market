-- Wstawianie danych do tabeli users
INSERT INTO market.users (email, login, name, password, surname) 
VALUES 
('jan.kowalski@example.com', 'jan_kowalski', 'Jan', 'password123', 'Kowalski'),
('anna.nowak@example.com', 'anna_nowak', 'Anna', 'pass123', 'Nowak'),
('piotr.wisniewski@example.com', 'piotr_wisniewski', 'Piotr', 'wisniewski123', 'Wiśniewski');

-- Wstawianie danych do tabeli address
INSERT INTO market.address (city, local_number, postal_code, street, street_number, voivodeship, user_id) 
VALUES 
('Warszawa', 12, '00-001', 'Aleje Jerozolimskie', 15, 'Mazowieckie', 1),
('Kraków', 4, '30-001', 'Rynek Główny', 5, 'Małopolskie', 2),
('Gdańsk', 8, '80-001', 'ul. Długa', 10, 'Pomorskie', 3);

-- Wstawianie danych do tabeli product
INSERT INTO market.product (description, photo, price, product_name) 
VALUES 
('Gdy Twój budzik zaczyna krzyczeć „KuCURRYku!!! a Ty nie masz siły wstać z łóżka po wczorajszej imprezie, zupa o Smaku Kurczaka Curry błyskawicznie postawi Cię na nogi. Jej fantastyczny smak to efekt doskonale skomponowanej mieszanki przypraw. Dodatek chilli rozgrzeje Cię do czerwoności, dając energię na cały dzień! Przechowywać w suchym, chłodnym i nienasłonecznionym miejscu.
Odpowiedni dla Wegan.', 'photo1.jpg', 1.99, 'Zupka chińska Vifon Curry ostra 70 g'),
('Rower elektryczny LOVELEC LUGO 2023
KOLOR: SZARY
BATERIA: 10 AH zasięg do 90 km
LOVELEC - czeska marka rowerów elektrycznych z dwunastoletnią tradycją', 'photo2.jpg', 3499.99, 'Rower elektryczny Lovelec Lugo rama 14 cali aluminium koło 20 " srebrny 250 W'),
('LENOR CREASE SPRONG AWAKENING żelazko w sprayu usuwa niewielkie zagniecenia na ubraniach bez konieczności użycia żelazka.
Sprawdzi się również jako odświeżający spray do pościeli, kanapy, zasłon i firan, dywanu oraz tapicerki.
', 'photo3.jpg', 24.99, 'Woda zapachowa uniwersalne Lenor 0,5 l');

-- Wstawianie danych do tabeli product_quantity
INSERT INTO market.product_quantity (quantity_available, product_id) 
VALUES 
(100, 1),
(50, 2),
(200, 3);

-- Wstawianie danych do tabeli photo_gallery
INSERT INTO market.photo_gallery (name_jpg, product_id) 
VALUES 
('photo1.jpg', 1),
('photo2.jpg', 2),
('photo3.jpg', 3);

INSERT INTO market.orders (is_order_completed, order_date, price, client_id) 
VALUES 
(1, '2024-04-01 10:30:00', 150.00, 1),
(1, '2024-05-02 15:45:00', 99.99, 2),
(1, '2024-05-03 12:00:00', 299.90, 3);

INSERT INTO market.product_order (orders_id, product_id, quantity)
VALUES
(1, 1, 3),
(2, 1, 3),
(2, 2, 3),
(3, 3, 1);

UPDATE market.orders o
SET o.price = ROUND((
    SELECT SUM(p.price * po.quantity)
    FROM market.product_order po
    JOIN market.product p ON po.product_id = p.id
    WHERE po.orders_id = o.id
),2);


