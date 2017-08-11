


CREATE TABLE menu (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    imgURL TEXT,
    price DOUBLE
);


CREATE TABLE orders (
	order_id INTEGER AUTO_INCREMENT PRIMARY KEY,
	customer_name VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL
);


INSERT INTO menu (id, name, description, imgURL, price) VALUES
(1, "Pizza", "Yummy", "images/pizza1.png", 6.99),
(2, "Hamburger", "Delicious", "images/hamburger1.png", 6.99),
(3, "Cheese Burger", "Mouth-Watering", "images/burger1.png", 5.99);


INSERT INTO orders (order_id, customer_name, status) VALUES
(1, "Eric", "IN PROGRESS"),
(2, "Damin", "IN QUEUE");


