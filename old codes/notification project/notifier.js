// notifier.js
const WebSocket = require('ws');

const ws = new WebSocket('ws://localhost:8081');

ws.on('open', () => {
  let count = 1;
  setInterval(() => {
    const msg = `🔔 Notification #${count} at ${new Date().toLocaleTimeString()}`;
    console.log(`📤 Sending: ${msg}`);
    ws.send(msg);
    count++;
  }, 5000);
});
