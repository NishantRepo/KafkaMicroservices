kakfa with spring boot example
base domain service
order service 
email service
stock service

inorder to run these mocrosrvices then follow below commands
1 download kafka and zookeeper
2 start zppkeeper and kafka service in in local system
command to run zookeeper and kafka service in windows
==>> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
==>> .\bin\windows\kafka-server-start.bat .\config\server.properties
#  read massages in kafka service
#  .\bin\windows\kafka-console-consumer.bat --topic myTopic --from-beginning --bootstrap-server localhost:9092
#  .\bin\windows\kafka-console-consumer.bat --topic myJsonTopic --from-beginning --bootstrap-server localhost:9092

