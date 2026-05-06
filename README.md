# Redis Caching with Spring Boot 

## Overview

This project demonstrates how to integrate Redis caching into a Spring Boot application to improve API performance and reduce database load.

The application manages product data and uses Redis as a caching layer for frequently accessed APIs.

---

# What I Learned

Through this project, I learned:

- What caching is and why it is important
- How Redis works as an in-memory data store
- How to integrate Redis with Spring Boot
- How to use:
  - `@Cacheable`
  - `@CachePut`
  - `@CacheEvict`
- How Redis improves API performance
- How cache invalidation works
- How to use Apache JMeter for load testing
- How Redis reduces database load during high traffic

---

# Problem Statement

In high-traffic applications such as e-commerce platforms, repeatedly fetching the same data directly from the database can cause:

- Slow response times
- High database load
- Application failures during traffic spikes

To solve this problem, Redis caching was integrated into the Spring Boot application.

---

# Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Redis
- MySQL
- Apache JMeter
- Gradle

---

# Setup - Environment

Ensure Redis is installed and running locally.

## Start Redis

```bash
redis-server
```

## Verify Redis

```bash
redis-cli ping
```

### Expected Output

```bash
PONG
```

---

# Running the Application

```bash
./gradlew bootrun
```

---

# Redis Dependencies

Add the following dependencies in `build.gradle`:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
implementation 'org.springframework.boot:spring-boot-starter-cache'
```

---

# Redis Configuration

Configure `application.properties`:

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
spring.data.redis.repositories.enabled=false
spring.cache.redis.time-to-live=1500000
```

---

# API Endpoints

## Create Product

```http
POST /api/products
```

### Request Body

```json
{
  "id": 1,
  "name": "Apple Watch - Series 5",
  "price": 20000.0
}
```

---

## Get Product

```http
GET /api/products/1
```

---

## Update Product

```http
PUT /api/products/1
```

---

## Delete Product

```http
DELETE /api/products/1
```

---

# Redis Cache Flow

## First Request

```text
Client → Spring Boot → Database → Redis Cache
```

The first request fetches data from the database and stores it in Redis.

---

## Next Requests

```text
Client → Spring Boot → Redis Cache
```

The next requests directly fetch data from Redis without hitting the database.

---

# Redis Keys Example

## Get All Keys

```bash
keys *
```

### Output

```bash
1) "products::1"
2) "products::2"
```

## Get Cached Value

```bash
get products::1
```

---

# JMeter Load Testing

Apache JMeter was used to simulate high traffic with 20,000 requests.

## Test Configuration

- Threads: 20,000
- Ramp-up Time: 5 seconds
- Loop Count: 1

---

# Why Redis Was Needed

## Without Caching

```text
20,000 Requests → Database
```

### Result

- Slow response times
- High DB load
- Server bottlenecks

---

## With Redis

```text
1 Request → Database
19,999 Requests → Redis
```

### Result

- Faster API responses
- Reduced database load
- Better scalability

---

# Cache Invalidation

## `@CachePut`

Used to update Redis cache after updating data.

## `@CacheEvict`

Used to remove cache after deleting data.

---

# Key Takeaways

- Redis significantly improves API performance
- Caching reduces unnecessary database queries
- Cache consistency is important
- JMeter helps identify bottlenecks
- High-traffic systems require caching strategies

---

# Future Improvements

- Add Docker support
- Add Kafka for event-driven architecture
- Add AWS deployment
- Add monitoring with Prometheus and Grafana

---

# Author

## Nabeel Khan

GitHub:https://github.com/code-with-nabeel/Redis-Cashing-with-SpringBoot
