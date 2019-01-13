package com.icbc.jmx;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.util.Map;


public class JmxServerDemo {

    public static  void main(String[] args) throws IOException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();



        LocateRegistry.createRegistry(1099);
        JMXServiceURL jmxURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(jmxURL,null,server);
        ObjectName objectName = new ObjectName("MyMBean:name=studentobj");
        jcs.start();
        server.registerMBean(new Student(),objectName);
        for(;;){

        }
    }
}
