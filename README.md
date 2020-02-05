## Using sample image to test directly
We will publish sample image to dockerhub.

```
sudo docker run -p 8080:3000 --env GRPC_SERVER_URL=127.0.0.1:50051 advwacloud/grpc-sample-server:latest
```

>8080: external port, you can change this value by yourself

>3000: internal port (fixed value in code)

> GRPC_SERVER_URL: this http sample server will proxy the request to specified grpc server

## Rebuild image with your own modify
```
sudo docker build -t advwacloud/grpc-sample-server .
```




