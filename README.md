# SpringChat - Real-time WebSocket Chat Application

A real-time chat application built with Spring Boot, WebSockets, STOMP protocol, and PostgreSQL.

## Table of Contents
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Understanding STOMP](#understanding-stomp)
- [Architecture](#architecture)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [WebSocket Endpoints](#websocket-endpoints)
- [Docker Setup](#docker-setup)

## Features

- **Real-time messaging** using WebSockets and STOMP protocol
- **User presence detection** (online/offline status)
- **Message persistence** with PostgreSQL database
- **Private conversations** between users
- **Unread message notifications**
- **Containerized deployment** with Docker and Docker Compose
- **Nginx reverse proxy** for production-ready deployment

## Technology Stack

- **Backend**: Spring Boot 3.4.2, Spring WebSocket, Spring Data JPA
- **Frontend**: HTML, CSS, JavaScript (Vanilla)
- **WebSocket Client**: SockJS, STOMP.js
- **Database**: PostgreSQL 15
- **Containerization**: Docker, Docker Compose
- **Reverse Proxy**: Nginx
- **Build Tool**: Maven

## Understanding STOMP

### What is STOMP?

STOMP (Simple Text-Oriented Messaging Protocol) is a text-based messaging protocol that provides an interoperable wire format for messaging between clients and message brokers. It's designed to be simple and easy to implement.

### How STOMP Works in SpringChat

In SpringChat, STOMP is used as the messaging protocol on top of WebSockets to facilitate real-time communication:

1. **Connection Establishment**:
   - Client connects to the WebSocket endpoint `/ws` using SockJS
   - STOMP connection is established over this WebSocket connection

2. **Message Destinations**:
   - **Application destinations** (`/app/...`): Messages sent here are processed by Spring's `@MessageMapping` methods
   - **Broker destinations** (`/user/...`): Used for message broadcasting/routing to connected clients

3. **Message Flow**:
   - When User A sends a message to User B, the message is sent to `/app/chat`
   - The server processes the message and forwards it to User B's queue at `/user/{username}/queue/messages`
   - User B's STOMP client is subscribed to this queue and receives the message in real-time

4. **User Presence**:
   - Users announce their presence by sending messages to `/app/user.addUser`
   - Status updates are broadcast to all users via `/user/public`
   - When users disconnect, a message is sent to `/app/user.disconnectUser`

This architecture allows for real-time communication with server-side processing while maintaining message delivery guarantees.

## Architecture

The application follows a standard Spring Boot architecture with the following components:

### Backend Components

1. **Entity Layer**: Defines the data models
   - `User`: Represents chat users with online/offline status
   - `ChatMessage`: Represents individual messages
   - `ChatRoom`: Links senders and recipients for conversation tracking

2. **Repository Layer**: Provides data access using Spring Data JPA
   - `UserRepository`: Manages user data
   - `ChatMessageRepository`: Manages message storage and retrieval
   - `ChatRoomRepository`: Manages chat room relationships

3. **Service Layer**: Contains business logic
   - `UserService`: Handles user operations
   - `ChatMessageService`: Processes messages
   - `ChatRoomService`: Manages chat room creation and lookup

4. **Controller Layer**: Exposes REST and WebSocket endpoints
   - `ChatController`: Processes chat messages and requests
   - `UserController`: Manages user sessions and status

5. **WebSocket Configuration**: Sets up STOMP message broker and endpoints

### Frontend Components

1. **User Interface**: HTML/CSS for chat layout
   - Login screen
   - User list with status indicators
   - Chat area with message history

2. **WebSocket Client**: JavaScript using SockJS and STOMP.js
   - Connects to WebSocket endpoint
   - Subscribes to message queues
   - Sends messages to server

## Running the Application

### Prerequisites

- Java 17+
- Docker and Docker Compose
- Maven

### Quick Start with Docker Compose

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/springchat.git
   cd springchat
   ```

2. Build and start the containers
   ```bash
   docker-compose up -d
   ```

3. Access the application
   ```
   http://localhost:8080
   ```

### Manual Development Setup

1. Configure PostgreSQL database
   ```
   Create a database named 'springchatdb'
   Update application.properties if needed
   ```

2. Build the application
   ```bash
   mvn clean package
   ```

3. Run the application
   ```bash
   java -jar target/springchat-0.0.1-SNAPSHOT.jar
   ```

4. Access the application
   ```
   http://localhost:8080
   ```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users` | Get all connected users |
| GET | `/messages/{senderId}/{recipientId}` | Get chat history between two users |
| GET | `/messages/{id}` | Get a specific message by ID |

## WebSocket Endpoints

| Endpoint | Description |
|----------|-------------|
| `/ws` | WebSocket connection endpoint with SockJS fallback |
| `/app/chat` | Endpoint for sending chat messages |
| `/app/user.addUser` | Endpoint for registering user presence |
| `/app/user.disconnectUser` | Endpoint for user disconnection |
| `/user/{username}/queue/messages` | User-specific queue for receiving messages |
| `/user/public` | Public channel for user status updates |

## Docker Setup

The application uses a multi-container setup with Docker Compose:

1. **PostgreSQL Database**: Persistent storage for user data and messages
2. **Spring Boot Application**: The main application container
3. **Nginx**: Reverse proxy for handling client connections

### Configuration Files

- `Dockerfile`: Multi-stage build for the Spring Boot application
- `docker-compose.yml`: Orchestrates the multi-container setup
- `nginx.conf`: Configures the Nginx reverse proxy with WebSocket support

### Environment Variables

The following environment variables can be modified in `docker-compose.yml`:

- `DB_DATABASE_URL`: JDBC connection string
- `DB_USER`: Database username
- `DB_PASSWORD`: Database password

## Future Implementations

- User authentication with Spring Security
- HTTPS/TLS encryption
- Input validation and sanitization
- Rate limiting
- CSRF protection
