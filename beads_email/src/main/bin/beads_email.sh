#!/bin/bash

export BEADS_EMAIL=$OPENSHIFT_DATA_DIR/beads_email

export BEADS_EMAIL_LOG_DIR=$BEADS_EMAIL/log

export CLASSPATH=$BEADS_EMAIL/config:$BEADS_EMAIL/lib/*

java  com.beads.email.Launcher

