CREATE DATABASE IF NOT EXISTS starlog
	DEFAULT CHARACTER SET utf8mb4
	DEFAULT COLLATE utf8mb4_unicode_ci;

USE starlog;

CREATE TABLE IF NOT EXISTS users (
	id BIGINT NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
	nickname VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password_hash VARCHAR(255) NOT NULL,
	birth_date DATE NULL,
	role VARCHAR(20) NOT NULL DEFAULT 'USER',
	level_name VARCHAR(50) NOT NULL DEFAULT 'NEW EXPLORER',
	star_count INT NOT NULL DEFAULT 0,
	current_streak INT NOT NULL DEFAULT 0,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY uk_users_email (email),
	UNIQUE KEY uk_users_username (username)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS goals (
	id BIGINT NOT NULL AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	title VARCHAR(120) NOT NULL,
	category VARCHAR(40) NOT NULL,
	target_date DATE NULL,
	description TEXT NULL,
	status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
	progress_percent TINYINT NOT NULL DEFAULT 0,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY uk_goals_user_title (user_id, title),
	KEY idx_goals_user_id (user_id),
	KEY idx_goals_status (status),
	CONSTRAINT fk_goals_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
	CONSTRAINT chk_goals_progress CHECK (progress_percent BETWEEN 0 AND 100)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS daily_records (
	id BIGINT NOT NULL AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	record_date DATE NOT NULL,
	content TEXT NOT NULL,
	mood VARCHAR(30) NOT NULL,
	star_amount INT NOT NULL DEFAULT 1,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY uk_daily_records_user_date (user_id, record_date),
	KEY idx_daily_records_record_date (record_date),
	CONSTRAINT fk_daily_records_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS record_tags (
	id BIGINT NOT NULL AUTO_INCREMENT,
	record_id BIGINT NOT NULL,
	name VARCHAR(30) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY uk_record_tags_record_name (record_id, name),
	CONSTRAINT fk_record_tags_record FOREIGN KEY (record_id) REFERENCES daily_records (id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS routines (
	id BIGINT NOT NULL AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	goal_id BIGINT NULL,
	title VARCHAR(100) NOT NULL,
	frequency VARCHAR(20) NOT NULL DEFAULT 'DAILY',
	display_order INT NOT NULL DEFAULT 0,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY uk_routines_user_title (user_id, title),
	KEY idx_routines_user_id (user_id),
	KEY idx_routines_goal_id (goal_id),
	CONSTRAINT fk_routines_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
	CONSTRAINT fk_routines_goal FOREIGN KEY (goal_id) REFERENCES goals (id) ON DELETE SET NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS routine_checks (
	id BIGINT NOT NULL AUTO_INCREMENT,
	routine_id BIGINT NOT NULL,
	record_id BIGINT NOT NULL,
	checked BOOLEAN NOT NULL DEFAULT FALSE,
	PRIMARY KEY (id),
	UNIQUE KEY uk_routine_checks_routine_record (routine_id, record_id),
	CONSTRAINT fk_routine_checks_routine FOREIGN KEY (routine_id) REFERENCES routines (id) ON DELETE CASCADE,
	CONSTRAINT fk_routine_checks_record FOREIGN KEY (record_id) REFERENCES daily_records (id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS user_feedback (
	id BIGINT NOT NULL AUTO_INCREMENT,
	user_id BIGINT NULL,
	author_name VARCHAR(80) NOT NULL,
	message TEXT NOT NULL,
	category VARCHAR(40) NOT NULL DEFAULT 'GENERAL',
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	KEY idx_user_feedback_user_id (user_id),
	CONSTRAINT fk_user_feedback_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
) ENGINE=InnoDB;
