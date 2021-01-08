# Profissoes-REST
API REST para cadastro de Profissões

## Para rodar
- Acesse a raiz do projeto e digite:
docker build -t professions:latest .

- Para rodar o projeto:
docker-compose up --build --force-recreate

Em caso de erro com porta do mysql digite:
- sudo kill $(sudo lsof -t -i:3306)
sudo netstat -p -nlp | grep 3306


- O projeto é acessado através da URL:
http://localhost:8008/profissoes

- A documentação fica disponível em:
http://localhost:8008/swagger-ui/index.html

- Para parar o container:
docker-compose down

