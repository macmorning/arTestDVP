javac -classpath /opt/apache/tomcat6.0/lib/servlet-api.jar:/opt/bmc/ARSystem/midtier/WEB-INF/lib/GraphPlugin.jar HelloWorldPlugin.java
jar -cvf HelloWorldPlugin.jar HelloWorldPlugin.class
rm -fR /opt/bmc/ARSystem/midtier/PluginsCache/ittux8/HelloWorldPlugin/
