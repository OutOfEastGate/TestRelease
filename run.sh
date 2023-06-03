
#!/usr/bin/env bash
main_name='main'
gateway_name='gateway'
search_name='search'

docker stop ${gateway_name}
docker stop ${main_name}
docker stop ${search_name}
echo '----stop container----'
docker rm ${gateway_name}
docker rm ${main_name}
docker rm ${search_name}
echo '----rm container----'
docker rmi ${gateway_name}
docker rmi ${main_name}
docker rmi ${search_name}
echo '----rm images----'
docker build -f ./gateway/Dockerfile -t ${gateway_name} .
docker build -f ./main/Dockerfile -t ${main_name} .
docker build -f ./search/Dockerfile -t ${search_name} .
echo '----build image----'
docker run -id -p 8080:8080 \
--name=${gateway_name} ${gateway_name}
docker run -id -p 8081:8081 \
--name=${main_name} ${main_name}
docker run -id -p 8082:8082 \
--name=${search_name} ${search_name}
echo '----start container----'