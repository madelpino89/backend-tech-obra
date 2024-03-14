CREATE TABLE Products (
    id_product INT NOT NULL,
    name VARCHAR(100),
    description VARCHAR(255),
    price DECIMAL(10, 2),
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES Orders(id_orders),
    PRIMARY KEY(id_product)
);

INSERT INTO Products (id, name, description, price, order_id) VALUES
(1,'Cement','Bag of Portland cement for construction.',25.00,1),
(2,'Bricks','Package of ceramic bricks for building.',1.20,1),
(3,'Wood for construction','Treated wood planks for use in construction projects.',15.00, 1);

CREATE TABLE Orders (
    id_orders INT NOT NULL,
    creation_date TIMESTAMP,
    total_product INT,
    total_price_without_iva DECIMAL(10, 2),
    total_price_with_iva DECIMAL(10, 2),
    status VARCHAR(10),
    PRIMARY KEY(id_orders)
);

INSERT INTO Orders (id,creation_date, total_product, total_price_without_iva, total_price_with_iva, status) VALUES
(1,'2024-02-19 12:30:00',2,67.40,77.51,'PENDING'),
(2,'2024-02-19 14:45:00',1,1.20,1.38,'CANCELLED'),
(3,'2024-02-19 16:00:00',3,44.10,50.76,'COLLECTED');