
USE noti;

-- insert data (JIRA PROJECT)
insert into jira (name,issue_key,auth_token,create_at,update_at,status) values ('JIRA PROJECET', 'issue key', 'auth token', now(), now(), 0);

-- insert data (HIPCHAT_ROOM)
insert into hipchat_room (room_id,name,create_at,update_at,status) values (1,'roon name', now(),now(),0);

-- insert data (jira_room_rel)
insert into jira_hipchatroom_rel (jira_issue_key,room_id) values('JIRA',1);
