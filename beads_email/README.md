#where build was done
~/app-root/runtime/repo/beads_email/target/beads_email.zip

#copy beads_email artifact from UAT host to prod
scp ~/app-root/repo/beads_email/target/beads_email.zip 54889dd8e0b8cdfdb500002e@na-igle.rhcloud.com:~/app-root/data/beads_email/

#sync directories between UAT and prod
#run from UAT host
rsync -arvz --progress  ~/app-root/data/beads_email  54889dd8e0b8cdfdb500002e@na-igle.rhcloud.com:~/app-root/data