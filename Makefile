
DOCKER_COMPOSE = docker compose
DOCKER_COMPOSE_FILE = docker-compose.yml

.PHONY: build-backend build-frontend start stop down clean

build-backend:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) build backend -f application-store/Dockerfile-backend

build-frontend:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) build frontend

start:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) up -d

stop:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) stop

down:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) down

clean:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) down -v

