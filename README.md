
!!!!!!!! NEED TO ADD Usage flow with some 
picture

note:!! 這只是sample提供參考而已, 此web server並沒有特別作錯誤例外處理, 請開發者依據實際情況實作

列個簡單的api doc

req end point
req body
resp example

## Prerequisition

Runnable GRPC SERVER

## Using sample image to test directly
We will publish sample image to dockerhub.

```
sudo docker run -p 8080:3000 --env GRPC_SERVER_URL=127.0.0.1:50051 advwacloud/cloud-sdk-java-sample
```

>8080: external port, you can change this value by yourself

>3000: internal port (fixed value in code)

> GRPC_SERVER_URL: this http sample server will proxy the request to specified grpc server

## Rebuild image with your own modify
```
sudo docker build -t advwacloud/cloud-sdk-java-sample .
```




