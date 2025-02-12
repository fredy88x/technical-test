# Inventory App

Web application to manage companies and products.

## Architecture

![Technical-Test-Architect-Technical-Test](https://github.com/user-attachments/assets/86b3227b-9e23-4729-bc17-118b0848d110)


## Installation

Execute the docker containers for service, using this commands:

```
docker build -t product .
docker build -t company .

docker pull mysql/mysql-server
docker run --name=mysql-server -d -p 3308:3306 mysql/mysql-server:latest

docker run --name=product-service -d -p 8083:8083 product-service:latest
docker run --name=company-service -d -p 8083:8083 company-service:latest
```
To execute the front side, we must locate the inventory-app directory and after executing this command in local:

```
pnpm i
pnpm dev
```


