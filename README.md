#ソースコード取得
$ git clone git@github.com:pnsk/jira-hipchat-noti.git
$ cd tool-noti
# DB情報作成
$ mysql -uroot < scripts/noti/ddl/create_notification_data.sql
$ mysql -uroot < scripts/noti/dml/insert_notification_data.sql
$ mysql -uroot < scripts/pj/ddl/create_project_data.sql
$ mysql -uroot < scripts/pj/dml/insert_projects_data.sql
# 実行
$ mvn clean compile spring-boot:run
