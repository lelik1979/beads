#!/bin/bash

#set -x

db_user=$OPENSHIFT_MYSQL_DB_USERNAME
db_passwd=$OPENSHIFT_MYSQL_DB_PASSWORD
db=$OPENSHIFT_APP_NAME
db_host=$OPENSHIFT_MYSQL_DB_HOST
db_dump_file_name=db_dump.sql
now=$(date +"%m-%d-%Y_%T")

mysqldump -u $db_user -p$db_passwd -h $db_host $db > $OPENSHIFT_DATA_DIR/$db_dump_file_name
if [ "$?" -ne "0" ]; then
    touch DB_DUMP_NOT_OK_$now
    exit 1
fi
zip -T9 db_dump_$now.zip ./$db_dump_file_name
if [ "$?" -eq "0" ]; then
    rm $db_dump_file_name
fi

