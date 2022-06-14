# MustGather Classloader problem case

## Start classloader container on docker or openshift

Follow steps described at parent folder's README 


## Access to the servlet to load classes

Access to following URL by your browser

- http://localhost:9080/classloader.web/loadclasses

Page just shows 
```
Served at: /classloader.web
```

You can check that classload behavior with websphere messages.log and trace.


## Check messages.log and trace

Please check /logs/trace.log to investigate classloader behavior.


## Log example

trace.log example. You can use request url, time and expected sql to find related thread activity.
```
pdprof.classloader.web.LoadClass is loaded from com.ibm.ws.classloading.internal.AppClassLoader@2c6feb71
pdprof.classloader.a.A is loaded from com.ibm.ws.classloading.internal.AppClassLoader@16d2a463
B is not found from pdprof.classloader.a.A
P is not found from pdprof.classloader.a.A
AA is FOUND from pdprof.classloader.a.A
pdprof.classloader.a.AA is loaded from com.ibm.ws.classloading.internal.AppClassLoader@16d2a463
pdprof.classloader.b.B is loaded from com.ibm.ws.classloading.internal.AppClassLoader@449e3238
A is not found from pdprof.classloader.b.B
P is not found from pdprof.classloader.b.B
pdprof.classloader.p.P is loaded from com.ibm.ws.classloading.internal.AppClassLoader@2c6feb71
A is FOUND from pdprof.classloader.p.P
B is FOUND from pdprof.classloader.p.P
```

Default configuration classload matrix
```
LoadClass > A, B, P
A > B, P, AA
B > A, P
P > A, B

LoadClass (web application classloader)
A (library A)
AA (library A)
B (library B)
P (private library .. same with web application classloader)
```

Please check other document after you recreate the problem by yourself.
