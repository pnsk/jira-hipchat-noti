

# DB
```bash
$ cd tool-noti
$ mysql -uroot < scripts/noti/ddl/create_notification_data.sql
$ mysql -uroot < scripts/noti/dml/insert_notification_data.sql
$ mysql -uroot < scripts/pj/ddl/create_project_data.sql
$ mysql -uroot < scripts/pj/dml/insert_projects_data.sql
```
# execute
```bash
$ mvn clean compile spring-boot:run
```
