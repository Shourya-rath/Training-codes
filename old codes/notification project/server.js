// server.js
const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8081 }, () => {
  console.log("🚀 WebSocket server running on ws://localhost:8081");
});

let clients = [];

wss.on('connection', (ws) => {
  clients.push(ws);
  console.log(`✅ New client connected. Total clients: ${clients.length}`);

  ws.on('close', () => {
    clients = clients.filter(client => client !== ws);
    console.log(`❌ Client disconnected. Total clients: ${clients.length}`);
  });

  ws.on('message', (data) => {
    console.log(`📨 Server received: ${data}`);

    // Forward to all clients
    clients.forEach(client => {
      if (client.readyState === WebSocket.OPEN) {
        client.send(data.toString());
      }
    });
  });
});
