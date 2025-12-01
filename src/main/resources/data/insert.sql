
DELETE FROM rental;
DELETE FROM cars;
DELETE FROM houses;
DELETE FROM pcs;
DELETE FROM mobile_phones;
DELETE FROM sound_systems;
DELETE FROM moneys;
DELETE FROM rentable_item;
DELETE FROM renters;

-- Réinitialiser les séquences
ALTER SEQUENCE rentable_item_id_seq RESTART WITH 100;
ALTER SEQUENCE renters_id_seq RESTART WITH 10;
ALTER SEQUENCE rental_id_seq RESTART WITH 50;

-- Insérer les renters
INSERT INTO renters (id, name, type) VALUES
                                         (1, 'Saint Mary Church', 'CHURCH'),
                                         (2, 'Lincoln High School', 'SCHOOL'),
                                         (3, 'John Doe', 'INDIVIDUAL'),
                                         (4, 'Jane Smith', 'INDIVIDUAL'),
                                         (5, 'Red Cross Association', 'ORGANIZATION'),
                                         (6, 'Tech Startup Inc', 'ORGANIZATION'),
                                         (7, 'Central University', 'SCHOOL'),
                                         (8, 'Community Center', 'ORGANIZATION');

-- Insérer les Cars
INSERT INTO rentable_item (id, name, description, type, available, base_price) VALUES
                                                                                   (1, 'Toyota Camry 2022', 'Mid-size sedan, automatic, fuel efficient', 'CAR', true, 50.00),
                                                                                   (2, 'BMW X5 2021', 'Luxury SUV, leather seats, premium package', 'CAR', true, 120.00),
                                                                                   (3, 'Ford F-150 2020', 'Pickup truck, 4x4, towing package', 'CAR', false, 80.00);

INSERT INTO cars (id, brand, model, year, engine_capacity, fuel_type) VALUES
                                                                          (1, 'Toyota', 'Camry', 2022, 2.5, 'Gasoline'),
                                                                          (2, 'BMW', 'X5', 2021, 3.0, 'Diesel'),
                                                                          (3, 'Ford', 'F-150', 2020, 5.0, 'Gasoline');

-- Insérer les Houses
INSERT INTO rentable_item (id, name, description, type, available, base_price) VALUES
                                                                                   (4, 'Beach Villa', '3 bedrooms, ocean view, private pool', 'HOME', true, 300.00),
                                                                                   (5, 'Downtown Apartment', 'Modern 2-bedroom apartment in city center', 'HOME', true, 150.00),
                                                                                   (6, 'Mountain Cabin', 'Cozy cabin with fireplace, perfect for weekends', 'HOME', false, 100.00);

INSERT INTO houses (id, address, square_meters, number_of_rooms) VALUES
                                                                     (4, '123 Beach Road, Malibu', 200.0, 3),
                                                                     (5, '456 Main Street, Downtown', 85.0, 2),
                                                                     (6, '789 Mountain Trail, Aspen', 120.0, 2);

INSERT INTO rentable_item (id, name, description, type, available, base_price) VALUES
                                                                                   (7, 'Gaming PC Pro', 'High-end gaming PC with RTX 4080', 'PC', true, 30.00),
                                                                                   (8, 'Workstation PC', 'Professional workstation for video editing', 'PC', true, 25.00),
                                                                                   (9, 'Basic Office PC', 'Standard PC for office work', 'PC', true, 15.00);

INSERT INTO pcs (id, brand, model, processor, ram_size_gb, storage_size_gb) VALUES
                                                                                (7, 'Alienware', 'Aurora R15', 'Intel i9-13900K', 32, 2000),
                                                                                (8, 'HP', 'Z8 G4', 'Intel Xeon W-2295', 64, 4000),
                                                                                (9, 'Dell', 'OptiPlex', 'Intel i5-12400', 16, 512);

-- Insérer les Mobile Phones
INSERT INTO rentable_item (id, name, description, type, available, base_price) VALUES
                                                                                   (10, 'iPhone 15 Pro', 'Latest iPhone with 256GB storage', 'MOBILE_PHONE', true, 20.00),
                                                                                   (11, 'Samsung Galaxy S23', 'Android flagship phone', 'MOBILE_PHONE', true, 18.00),
                                                                                   (12, 'Google Pixel 8', 'Best camera phone', 'MOBILE_PHONE', false, 16.00);

INSERT INTO mobile_phones (id, brand, model, ram_size_gb, storage_size_gb) VALUES
                                                                               (10, 'Apple', 'iPhone 15 Pro', 8, 256),
                                                                               (11, 'Samsung', 'Galaxy S23', 8, 256),
                                                                               (12, 'Google', 'Pixel 8', 8, 128);

-- Insérer les Sound Systems
INSERT INTO rentable_item (id, name, description, type, available, base_price) VALUES
                                                                                   (13, 'Premium Home Theater', '7.1 surround sound system', 'SOUND_SYSTEM', true, 40.00),
                                                                                   (14, 'Portable Bluetooth Speaker', 'Waterproof speaker for outdoor use', 'SOUND_SYSTEM', true, 10.00),
                                                                                   (15, 'DJ Equipment Set', 'Professional DJ mixer and speakers', 'SOUND_SYSTEM', true, 60.00);

INSERT INTO sound_systems (id, power_watts, number_of_speakers, bluetooth) VALUES
                                                                               (13, 1000, 8, true),
                                                                               (14, 50, 1, true),
                                                                               (15, 2000, 4, true);

-- Insérer les Moneys
INSERT INTO rentable_item (id, name, description, type, available, base_price) VALUES
                                                                                   (16, 'Emergency Loan', 'Short-term cash loan', 'MONEY', true, 5.00),
                                                                                   (17, 'Business Funding', 'Medium-term business loan', 'MONEY', true, 3.00),
                                                                                   (18, 'Student Loan', 'Educational funding', 'MONEY', true, 2.00);

INSERT INTO moneys (id, currency, minimum_lease_amount, repayment_delay_days) VALUES
                                                                                  (16, 'USD', 1000.00, 30),
                                                                                  (17, 'USD', 5000.00, 90),
                                                                                  (18, 'USD', 2000.00, 180);

INSERT INTO rental (id, renter_id, item_id, start_date, end_date, status, total_price, created_at) VALUES
                                                                                                       (1, 1, 3, '2024-11-01', '2024-11-30', 'COMPLETED', 2160.00, '2024-10-25 10:30:00'),
                                                                                                       (2, 2, 12, '2024-11-15', '2024-11-20', 'ACTIVE', 76.50, '2024-11-10 14:20:00'),
                                                                                                       (3, 3, 6, '2024-12-01', '2024-12-07', 'ACTIVE', 700.00, '2024-11-28 09:15:00'),
                                                                                                       (4, 5, 7, '2024-11-20', '2024-11-25', 'COMPLETED', 112.50, '2024-11-18 11:45:00'),
                                                                                                       (5, 4, 14, '2024-12-01', '2024-12-03', 'CANCELLED', 20.00, '2024-11-30 16:30:00');
