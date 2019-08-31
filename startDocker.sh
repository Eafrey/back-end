#!/usr/bin/env bash

rm app.tar.gz

docker-compose down

UNUSEIMAGES=$(docker images --filter "dangling=true" -q --no-trunc)
if [ "$UNUSEIMAGES" != "" ]; then
    docker rmi $UNUSEIMAGES
fi
docker-compose up --build -d