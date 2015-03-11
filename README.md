mail bbead72@gmail.com
passwd : KtyfKtyf

deploy database done via liquibase and can be deployed using this command
mvn liquibase:update -Denv=dev|prod|uat

#setup ssh tunel to mysql on UAT
ssh -L3307:127.7.245.2:3306  548c34854382ec18600000a9@uat-igle.rhcloud.com

#setup ssh tunel to mysql on PROD
ssh -L3308:127.6.110.130:3306  54889dd8e0b8cdfdb500002e@na-igle.rhcloud.com

DB customization done via env/dev|prod|uat.properties file

mysql must use parameters
characterEncoding=utf8;autoReconnect=true
to support russian chars

#to avoid ssh close connection by timeout we can unset variable
unset TMOUT

#setup 'env' property with value 'uat' in openshift application 'uat'
rhc set-env env=uat --app uat

#change deployment branch
rhc app-configure [app_name] --deployment-branch [branch_name]


#clean up space
rhc app-tidy uat

#show 50 biggest files/directories
du -h * | sort -rh | head -50

#show quota limits
$ quota -s
