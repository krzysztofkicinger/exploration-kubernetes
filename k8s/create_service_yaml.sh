#!/usr/bin/env bash

kubectl create service clusterip exploration-kubernetes --tcp=8080:8080 --dry-run -o=yaml >> service.yaml