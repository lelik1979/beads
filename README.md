The OpenShift `jbossews` cartridge documentation can be found at:

http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat


MySQL 5.5 database added.  Please make note of these credentials:

       Root User: adminBxsjzFX
   Root Password: dvrStQsCQGZ6
   Database Name: beads2

Connection URL: mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/

You can manage your new MySQL database by also embedding phpmyadmin.
The phpmyadmin username and password will be the same as the MySQL credentials above.

Please make note of these MySQL credentials again:
  Root User: adminBxsjzFX
  Root Password: dvrStQsCQGZ6
URL: https://beads2-lelik.rhcloud.com/phpmyadmin/


[beads2-lelik.rhcloud.com 53ff9c46e0b8cd9fee000e89]\> echo $OPENSHIFT_MYSQL_DB_HOST
127.7.157.130
[beads2-lelik.rhcloud.com 53ff9c46e0b8cd9fee000e89]\> echo $OPENSHIFT_MYSQL_DB_PORT
3306

ssh : 53ff9c46e0b8cd9fee000e89@beads2-lelik.rhcloud.com

Jenkins created successfully.  Please make note of these credentials:

   User: admin
   Password: NirJTA2ek3hq

Note:  You can change your password at: https://jenkins-lelik.rhcloud.com/me/configure