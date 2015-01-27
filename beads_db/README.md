#deploy database done via liquibase and can be deployed using this command
mvn liquibase:update -Denv=dev|prod|uat

#setup ssh tunel to mysql on UAT
ssh -L3307:127.7.245.2:3306  548c34854382ec18600000a9@uat-igle.rhcloud.com

#setup ssh tunel to mysql on PROD
ssh -L3308:127.6.110.130:3306  54889dd8e0b8cdfdb500002e@na-igle.rhcloud.com

DB customization done via env/dev|prod|uat.properties file