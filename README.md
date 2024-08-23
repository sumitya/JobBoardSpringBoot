# JobBoard Monolith App

SpringBoot Backend App, where users can add a Job, add company and a review of the company.

## Build

Build docker image using buildpack , which is available as a part of spring-boot-maven-plugin plugin.

```bash
./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=syadavgit/jobappimage"
```

## login to docker hub
```bash
docker login
```

## Run Job App -> Run Docker container from an image
```bash
docker run -p 8080:8080 syadavgit/jobappimage
```

## Run Job App in detached mode - as a background process mode
```bash
docker run -d -p 8080:8080 syadavgit/jobappimage
```

## See logs of a running container
```bash
docker logs 72ddc7f1f2ad(container id)
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.