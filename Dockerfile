FROM openjdk:17
ENV LANG en_US.utf8
ENV LC_ALL en_US.utf8

MAINTAINER wanghongtao <1946066280@qq.com>

ADD TestRelease-1.0.0-SNAPSHOT.jar main.jar
CMD java -jar main.jar
EXPOSE 8081