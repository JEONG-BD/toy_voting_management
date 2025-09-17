# ======================================
# ENV
# =====================================
IMAGE_NAME=voting-management
CONTAINER_NAME=voting-management
PORT=70000
DB_IMAGE_NAME=mysql:8.0
DB_CONTAINER_NAME=voting-service-db
DB_PORT=5002
DB_USER=admin
DB_PASSWORD=admin
DB_NAME=db
NETWORK=voting
# -------------------------
# Build
# -------------------------
build:
	docker build -t $(IMAGE_NAME) .
# -------------------------
# Run DB (MySQL)
# -------------------------
run_db:
	@echo "Removing existing container..."
	docker rm -f $(DB_CONTAINER_NAME)
	@echo "Starting new container..."
	docker run -d --name $(DB_CONTAINER_NAME) \
		--network $(NETWORK) -p $(DB_PORT):3306 \
		-e MYSQL_DATABASE=$(DB_NAME) \
		-e MYSQL_USER=$(DB_USER) \
		-e MYSQL_ROOT_PASSWORD=$(DB_PASSWORD) \
		-e MYSQL_PASSWORD=$(DB_PASSWORD) $(DB_IMAGE_NAME)
	@echo "Container started successfully!"

run_server:
	@echo "Removing existing container..."
	docker rm -f $(CONTAINER_NAME) || true
	@echo "Starting new container..."
	docker run -d --name $(CONTAINER_NAME) \
		--network $(NETWORK) -p $(PORT):$(PORT) \
		$(IMAGE_NAME)
	@echo "Container started successfully!"
