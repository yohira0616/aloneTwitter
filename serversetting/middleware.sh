#!/bin/sh

echo "java 8 install.."
sudo yum install -y java-1.8.0-openjdk.x86_64
echo "java 8 install done!"
echo "postgreSQL9.4 install..."
sudo yum -y localinstall http://yum.postgresql.org/9.4/redhat/rhel-6-x86_64/pgdg-centos94-9.4-1.noarch.rpm
sudo yum -y install postgresql94-server.x86_64
sudo service postgresql-9.4 initdb
sudo chkconfig postgresql-9.4 on
sudo service postgresql-9.4 start
echo "postgreSQL install done!"

