# Replica set de MongoDB

### Para levantar las replicas de mongo:

- PRIMERO SE LEVANTAN LAS REPLICAS DE MONGO QUE SE USARAN PARA EL REPLICA SET
	
`docker-compose -f docker-compose-mongo.yaml up -d --build`

- DESPUES SE INICIALIZA EL REPLICA SET INDICANDOLE EL NOMBRE Y LOS HOSTS QUE LE PERTENECEN
	
`docker-compose exec mongo1 mongo --eval "rs.initiate({_id : 'hiperiondevelreplicaset','members' : [{_id : 0, host : 'mongo1:27018'},{_id : 1, host : 'mongo2:27019'},{_id : 2, host : 'mongo3:27020'}]})"`