

use `cs3220xstu18`;
CREATE TABLE food_items (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    item VARCHAR(255) ,
    description VARCHAR(255) ,
    image VARCHAR(255),
    price 	DOUBLE);
    
    INSERT into food_items (item, description, image, price)values
    ( 'Hamburger','A hamburger','http://thedeliciousrevolution.com/wp-content/uploads/2009/09/Spinach-Burgers-615x411.jpg',  9.99) ,
    ('Fries','Some fries','http://thedeliciousrevolution.com/wp-content/uploads/2009/09/Spinach-Burgers-615x411.jpg',4.99),
    ('Coke', 'Coke cola', 'http://thedeliciousrevolution.com/wp-content/uploads/2009/09/Spinach-Burgers-615x411.jpg',   2.99) ;

drop table food_items;