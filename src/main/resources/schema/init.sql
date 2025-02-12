-- Create Users Table
CREATE TABLE IF NOT EXISTS admin (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Categories Table
--CREATE TABLE IF NOT EXISTS categories (
--    id IDENTITY PRIMARY KEY,
--    name VARCHAR(255) NOT NULL UNIQUE
--);
--
---- Create Expenses Table with Foreign Keys
--CREATE TABLE IF NOT EXISTS expenses (
--    id IDENTITY PRIMARY KEY,
--    description VARCHAR(255) NOT NULL,
--    amount DOUBLE NOT NULL,
--    user_id BIGINT NOT NULL,
--    category_id BIGINT NOT NULL,
--    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
--    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
--);