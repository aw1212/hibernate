-- having a schema.sql file in spring boot jpa app will run it on app startup
CREATE TABLE IF NOT EXISTS pikmin (id SERIAL PRIMARY KEY, color VARCHAR, quality VARCHAR, toss_distance INTEGER);
