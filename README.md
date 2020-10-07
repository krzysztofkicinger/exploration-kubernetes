# Exploration of Kubernetes

## Dashboard

### Commands

Install Kubernetes Dashboard:

```shell script
kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended/kubernetes-dashboard.yaml
```

Run proxy server (between localhost and Kubernetes apiserver)

```shell script
kubectl proxy
```

Creating service account for accessing the Dashboard:

```shell script
kubectl create serviceaccount dashboard-admin-sa
kubectl create clusterrolebinding dashboard-admin-sa --clusterrole=admin --serviceaccount=default:dashboard-admin-sa
```

Accessing token for created service account:

```shell script
kubectl get serviceaccounts 
kubectl get secrets 
kubectl describe secrets dashboard-admin-sa-token-gqhpk
```

Access Kubernetes Dashboard UI

```http request
http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
```

### References

1. https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
1. https://www.replex.io/blog/how-to-install-access-and-add-heapster-metrics-to-the-kubernetes-dashboard

## Minikube basics

Start/stop commands:

```shell script
minikube start --driver=docker
minikube status
minikube stop
```

Accessing minikube:

```shell script
docker container list
docker container exec -it <CONTAINER_ID> /bin/bash
```

Creating a tunnel to the service:

```shell script
minikube service exploration-kubernetes-load-balancer
```

## Kubectl commands

```shell script
kubectl apply -f deployment.yaml
kubectl apply -f k8s/service.yaml

kubectl delete pod/exploration-kubernetes-79bfc5f678-qxcrc
kubectl delete deployment.apps/exploration-kubernetes
kubectl delete pods,services -l app=exploration-kubernetes
kubectl delete -f k8s/deployment.yaml

kubectl create -f k8s/deployment.yaml
kubectl create --save-config -f k8s/deployment.yaml

kubectl get all
kubectl get deployments
kubectl get pods,services -l app=exploration-kubernetes

kubectl logs exploration-kubernetes-application-5f6b569795-7jt4h
kubectl logs -l app=exploration-kubernetes
```

### References

1. https://spring.io/guides/gs/spring-boot-kubernetes/
1. https://learnk8s.io/spring-boot-kubernetes-guide
1. https://www.baeldung.com/spring-cloud-kubernetes
1. https://www.baeldung.com/spring-boot-minikube#5-cleaning-up-service-and-deployment