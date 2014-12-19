#!/bin/bash

find $OPENSHIFT_DATA_DIR -type f -name 'db_dump_*.zip' -mtime +0  -exec rm {} \;
