# runtime-springboot

Para desplegar directamente en openshift, una vez logueando en la terminal.

```
$ mvn fabric8:deploy -Popenshift
```

## run this locally

First be sure to configure your database in `application-local.yaml`.

Then run the service using the `local` profile:
```
$ mvn clean spring-boot:run -Drun.profile=local
```