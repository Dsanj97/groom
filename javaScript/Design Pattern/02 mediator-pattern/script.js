class Participant {
    constructor(name) {
        this.name = name;
        this.chatRoom = null;
        this.messages = [];
    }

    send(message, to) {
        this.chatRoom.send(message, this, to)
    }

    receive(message, from) {
        this.messages.push({message, from});
    } 

    showMessages() {
        console.log(this.messages);
    }
}

class ChatRoom {
    constructor() {
        this.participants = {};
    }

    enter(participant) {
        this.participants[participant.name] = participant;
        participant.chatRoom = this;
    }
    send(message, participant, to) {
        this.participants[to.name].receive(message, participant);
    }
}

const kako = new ChatRoom();

const user1 = new Participant('user1');
const user2 = new Participant('user2');
const user3 = new Participant('user3');

kako.enter(user1);
kako.enter(user2);
kako.enter(user3);  

console.log(kako)
console.log(user1)

user1.send('hi', user2);
user1.send('hi22222222', user2);

console.log(kako);