mail bbead72@gmail.com
passwd : KtyfKtyf

deploy database done via liquibase and can be deployed using this command
mvn liquibase:update -Denv=dev|prod|uat

#setup ssh tunel to mysql on UAT
ssh -L3307:127.5.25.130:3306  550e00b84382ec927f0001e1@uat-igle.rhcloud.com

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
#full list of features
rhc app-configure --help


#clean up space
rhc app-tidy uat1

#show 50 biggest files/directories
du -h * | sort -rh | head -50

#show quota limits
$ quota -s

#clean up some space
webapps -> /var/lib/openshift/55005f124382ec4a6a00014d/app-root/runtime/dependencies/jbossews/webapps
Building war: /var/lib/openshift/55005f124382ec4a6a00014d/app-root/runtime/repo/webapps/ROOT.war
rm -rf ~/app-root/runtime/repo/.m2/repository/*
rm -rf ~/app-root/runtime/build-dependencies/*

rm -rf ~/app-deployments/2015-03-19_15-25-53.921/*
rm -rf ~/jbossews/webapps
cp ~/app-root/runtime/repo/webapps/ROOT.war ~/jbossews/webapps

gear stop/start jbossews