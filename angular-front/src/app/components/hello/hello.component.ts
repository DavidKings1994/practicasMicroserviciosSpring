import { Component, OnInit } from '@angular/core';
import { WebSocketApi } from '../../classes/web-socket-api';

@Component({
    selector: 'app-hello',
    templateUrl: './hello.component.html',
    styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

    title = 'angular8-springboot-websocket';
    webSocketAPI: WebSocketApi;
    greeting: any;
    name: string;

    ngOnInit() {
        this.webSocketAPI = new WebSocketApi();
    }

    connect() {
        this.webSocketAPI._connect();
    }

    disconnect() {
        this.webSocketAPI._disconnect();
    }

    sendMessage() {
        this.webSocketAPI._send(this.name);
    }

    handleMessage(message: string) {
        this.greeting = message;
    }

}
