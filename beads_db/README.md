#clear check sum errors
mvn liquibase:clearCheckSums  -Denv=dev

#check what will be applied
mvn clean compile liquibase:status -Denv=dev|uat|prod

#generate sql which will be applied.  target/migrationSql.sql will be populated
mvn clean compile  liquibase:updateSQL -Denv=dev

#deploy database done via liquibase and can be deployed using this command
mvn clean compile liquibase:update -Denv=dev|prod|uat

#setup ssh tunel to mysql on UAT
ssh -L3307:127.5.25.130:3306  550e00b84382ec927f0001e1@uat-igle.rhcloud.com

#setup ssh tunel to mysql on PROD
ssh -L3308:127.6.110.130:3306  54889dd8e0b8cdfdb500002e@na-igle.rhcloud.com

DB customization done via env/[dev|prod|uat]_db.properties file