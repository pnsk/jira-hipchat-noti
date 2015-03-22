

/**
   プロジェクト情報
 */
CREATE DATABASE IF NOT EXISTS projects;

USE projects;
-- project table
CREATE TABLE IF NOT EXISTS project (id INT UNSIGNED KEY AUTO_INCREMENT, name CHAR(32) CHARACTER SET 'utf8', development_code CHAR(32) CHARACTER SET 'utf8', create_at DATETIME, update_at DATETIME, status TINYINT DEFAULT 0);
