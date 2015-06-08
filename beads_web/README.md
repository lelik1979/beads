#copy war from UAT to prod
scp ~/app-root/repo/webapps/ROOT.war 54889dd8e0b8cdfdb500002e@na-igle.rhcloud.com:~/jbossews/webapps

#from NA server
#copy ROOT.war from UAT to prod
scp 550e00b84382ec927f0001e1@uat-igle.rhcloud.com:~/app-root/repo/webapps/ROOT.war ~/jbossews/webapps

gear start jbossews