CREATE TABLE Skills (
    skill_id SERIAL PRIMARY KEY,
    skill_name VARCHAR(50), 
	created_by VARCHAR(50) DEFAULT null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT null,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Skills (skill_name) VALUES 
('Java'),
('Python'),
('React'),
('Machine Learning'),
('Springboot Framework'),
('Microservices'),
('Angular'),
('Node.Js'),
('MySql'),
('SQL'),
('Oracle Sql'),
('Oracle'),
('.net');