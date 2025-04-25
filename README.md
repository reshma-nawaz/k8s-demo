# Customer Microservice – Java Spring Boot with Docker, Kubernetes & Minikube

This project is a *self-learning* exploration to understand the process of containerizing a *Java Spring Boot microservice, setting up a PostgreSQL database, and deploying the full stack using **Kubernetes on Minikube*.

It includes a full CRUD API for managing customer data.

---

## Tech Stack

- *Backend:* Java Spring Boot
- *Database:* PostgreSQL
- *Containerization:* Docker
- *Orchestration:* Kubernetes
- *Local Cloud Environment:* Minikube
---

## Endpoints

| Method | Endpoint                              | Description                |
|--------|---------------------------------------|----------------------------|
| GET    | /api/v1/customers                   | Get all customers          |
| GET    | /api/v1/customers/{customerId}      | Get customer by ID         |
| POST   | /api/v1/customers                   | Create a new customer      |
| PUT    | /api/v1/customers/{customerId}      | Fully update a customer    |
| PATCH  | /api/v1/customers/{customerId}      | Partially update customer  |

---
## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/customer-microservice.git
cd customer-microservice

# Kuberentes setup on the minikube
minikube start

# Apply Kubernetes configs
kubectl apply -f k8s/postgres-secret.yaml
kubectl apply -f k8s/postgres-deployment.yaml
kubectl apply -f k8s/backend-deployment.yaml

# Check pods and Service status
kubectl get pods
kubectl get svc
# Access the Application
minikube ip
kubectl get svc <applicationServiceName>
http://<minikube-ip>:<NodePort>/api/v1/customers

# Testing the API
curl http://<minikube-ip>:<node-port>/api/v1/customers

# Or perform doing tunneling
kubectl service <applicationServiceName> - it'll provide an IP.
