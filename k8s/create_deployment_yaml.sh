#!/usr/bin/env bash

kubectl create deployment exploration-kubernetes --image=exploration-kubernetes:demo --dry-run -o=yaml >> deployment.yaml