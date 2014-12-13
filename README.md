The OpenShift `jbossews` cartridge documentation can be found at:

http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat


MySQL 5.5 database added.  Please make note of these credentials:

       Root User: adminjWtFQq8
   Root Password: 9cvX9c2QjfIF
   Database Name: beads3

Connection URL: mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/

You can manage your new MySQL database by also embedding phpmyadmin.
The phpmyadmin username and password will be the same as the MySQL credentials above.

Please make note of these MySQL credentials again:
  Root User: adminjWtFQq8
  Root Password: 9cvX9c2QjfIF
URL: https://beads3-lelik.rhcloud.com/phpmyadmin/

git ssh:
ssh://541892755973ca4d2b000819@beads3-lelik.rhcloud.com/~/git/beads3.git/


mail bbead72@gmail.com
passwd : KtyfKtyf

deploy database done via liquibase and can be deployed using this command
mvn liquibase:update -Denv=dev|prod|uat

DB customization done via env/dev|prod|uat.properties file

mysql must use parameters
characterEncoding=utf8;autoReconnect=true
to support russian chars

#to avoid ssh close connection by timeout we can unset variable
unset TMOUT

#setup 'env' property with value 'uat' in openshift application 'uat'
rhc set-env env=uat --app uat