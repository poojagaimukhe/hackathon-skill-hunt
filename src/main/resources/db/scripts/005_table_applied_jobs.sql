CREATE TABLE users_applied_job (
    applied_id SERIAL PRIMARY KEY,
    applied_by VARCHAR(50),
--    post_id INT REFERENCES job_post(post_id),
	created_by VARCHAR(50) DEFAULT null,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT null,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);