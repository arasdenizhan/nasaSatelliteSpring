docker_build (M1_CHIP):
	docker build -t demo-project:latest .
docker_run (M1_CHIP):
	docker run --platform=linux/amd64 --name=demo-project -p 8080:8080 demo-project:latest