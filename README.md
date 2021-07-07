# Replica set de MongoDB

> Para este ejemplo se usa la iamgen de docker de `bitmani/mongodb:4.4` - La configuracion cambia para otras versiones

### Para levantar las replicas de mongo:

#### LEVANTAR LAS REPLICAS DE MONGO QUE SE USARAN PARA EL REPLICA SET
	
		docker-compose -f docker-compose-mongo.yaml up -d --build
		
> Formato de la replica primaria:

```
  mongo1:
    image: docker.io/bitnami/mongodb:4.4
    ports:
      - 27018:27017
    environment:
      - MONGODB_ADVERTISED_HOSTNAME=mongo1
      - MONGODB_REPLICA_SET_MODE=primary
      - MONGODB_REPLICA_SET_NAME=hiperiondevelreplicaset
      - MONGODB_REPLICA_SET_KEY=HIPERIONDEVKEY
      - MONGODB_ROOT_PASSWORD=root
      - MONGODB_DATABASE=test
    volumes:
      - ./data/mongo:/bitnami/mongodb
```

> Formato de la replicas secundarias:

```
  mongo2:
    image: docker.io/bitnami/mongodb:4.4
    ports:
      - 27019:27017
    environment:
      - MONGODB_ADVERTISED_HOSTNAME=mongo2
      - MONGODB_REPLICA_SET_MODE=secondary
      - MONGODB_REPLICA_SET_KEY=HIPERIONDEVKEY
      - MONGODB_INITIAL_PRIMARY_HOST=mongo1
      - MONGODB_INITIAL_PRIMARY_ROOT_PASSWORD=root
    depends_on:
      - mongo1
```

> La ruta del almacenamiento en el contenedor es "/bitnami/mongodb" y solo se define en la replica primaria

---