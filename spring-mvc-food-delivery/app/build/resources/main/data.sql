INSERT INTO FOOD(name, calorie, description, price, category)
SELECT "name", CAST("calorie" AS INT), "description", CAST("price" AS NUMERIC(10,2)), "category"
FROM CSVREAD('D:\\Epam\\Modules\\JavaPersistence\\java-persistence-food-delivery\\app\\src\\main\\resources\\input\\foods.csv', 'name, calorie, description, price, category', NULL);

INSERT INTO CUSTOMER(email, password, id, name, balance)
SELECT "email", "password", CAST("id" AS INT), "name", CAST("balance" AS DECIMAL(19,2))
FROM CSVREAD('D:\\Epam\\Modules\\JavaPersistence\\java-persistence-food-delivery\\app\\src\\main\\resources\\input\\customers.csv', 'email, password, id, name, balance', NULL);

