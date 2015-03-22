/**
　notificationに必要なテーブルたち
　半分メモだから確認してから実行することﾍ(ﾟ∀ﾟﾍ)
 */

CREATE DATABASE IF NOT EXISTS noti;

USE noti;
-- jira table
CREATE TABLE IF NOT EXISTS jira (id INT UNSIGNED KEY AUTO_INCREMENT, name CHAR(32) CHARACTER SET 'utf8', issue_key CHAR(32) CHARACTER SET 'utf8', auth_token CHAR(32) CHARACTER SET 'utf8', create_at DATETIME, update_at DATETIME, status TINYINT DEFAULT 0);

-- hipcaht_room table
CREATE TABLE IF NOT EXISTS hipchat_room(id INT UNSIGNED KEY AUTO_INCREMENT, room_id INT UNSIGNED, name CHAR(32) CHARACTER SET 'utf8', create_at DATETIME, update_at DATETIME, status TINYINT DEFAULT 0);

-- jira_hipchatroom_rel table
CREATE TABLE IF NOT EXISTS jira_hipchatroom_rel(jira_issue_key CHAR(32), room_id INT);
