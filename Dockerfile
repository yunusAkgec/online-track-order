FROM ubuntu:latest
LABEL authors="yunus"

ENTRYPOINT ["top", "-b"]