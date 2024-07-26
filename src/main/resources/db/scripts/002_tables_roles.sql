CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50),
	created_by VARCHAR(50) DEFAULT null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT null,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO roles (role_name) VALUES ('Admin'), ('User');