# PDPro Application

## Requirements

- [Docker](https://www.docker.com/)

## Test on Docker

### Build docker image

```
setup-docker.sh
```

### Start docker 
```
mkdir ~/pdprof
docker run --rm -p 9443:9443 -p 9080:9080 classloader
```

Now you can access http://localhost:9080/classloader.web/loadclasses


## Test on OpenShift

After you setup CRC described at [icp4a-helloworld](https://github.com/pdprof/icp4a-helloworld)

You can use following script. 
```
setup-openshift.sh
```

Now you can access to http://classloader-route-default.apps-crc.testing/loadclasses

Other test steps are same with docker.
