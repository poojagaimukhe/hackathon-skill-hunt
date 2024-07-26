CREATE TABLE job_post (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    descr VARCHAR(255),
    posted_by VARCHAR(255),
    skill_details VARCHAR(255),
    user_id INT,
    totalExperience  VARCHAR(255),
    is_deleted VARCHAR(255),
    created_by VARCHAR(50) DEFAULT null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT null,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);