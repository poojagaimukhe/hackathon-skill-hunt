CREATE TABLE user_info (
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    username VARCHAR(50),
    role VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(50),
    is_deleted VARCHAR(50),
	created_by VARCHAR(50) DEFAULT null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT null,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

