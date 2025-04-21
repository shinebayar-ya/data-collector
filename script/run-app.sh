#!/bin/bash

# Step 1: Build native image
echo "Building native image..."
./mvnw clean package -Dnative -Dquarkus.native.container-build=true

if [ $? -ne 0 ]; then
  echo "Native image build failed!"
  exit 1
fi

# Step 2: Build Docker image
echo "Building Docker image from Dockerfile.native..."
DOCKER_BUILDKIT=1 docker build -f src/main/docker/Dockerfile.native -t quarkus-native-app .

if [ $? -ne 0 ]; then
  echo "Docker image build failed!"
  exit 1
fi

# Step 3: Start containers using Docker Compose
echo "Starting containers using Docker Compose..."
docker-compose up --build

if [ $? -ne 0 ]; then
  echo "Docker Compose failed!"
  exit 1
fi

echo "Application is running! Access it at http://localhost:8080"
