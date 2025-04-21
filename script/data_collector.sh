#!/bin/bash

# Configurations
INPUT_FOLDER="${INPUT_FOLDER:-/default/input/folder}"  # Default to /default/input/folder if not set
OUTPUT_FOLDER="${OUTPUT_FOLDER:-/default/output/folder}"  # Default if not set
ML_SERVICE_URL="${ML_SERVICE_URL:-http://localhost:8080/api/execute}"  # Default if not set
CONTENT_TYPE="application/json"

# Function to send data to ML service
collect_data_from_file() {
  curl --location "$ML_SERVICE_URL" \
    --header "Content-Type: $CONTENT_TYPE" \

  
}