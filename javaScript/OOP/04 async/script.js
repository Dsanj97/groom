function fetchData() {
    return new Promise((resolve, reject) => {
        // 비동기 요청

        const success = false;
        if (success) {
            resolve('success');
        } else {
            reject('fail');
        }
    });
}

fetchData()
   .then((response) => {
        console.log(response);
    })
    .catch((error) => {
        console.log(error);
    });

// fetch으ㅏ 경우 promise 를 지원하므로 그냥 사용이 가능하다
// fetch 로 받아올경우 한번은 jason으로 바꿔줘야 한다
fetch('http://jsonplaceholder.typicode.com/todos/1')
   .then(response => response.json())
   .then(data => console.log(data))
   .then(() => fetch('http://jsonplaceholder.typicode.com/todos/2'))
   .then(response1 => response1.json())
   .then(data1 => console.log(data1))
   .catch(error => console.log(error))
   .finally(() => console.log('finally'));

// async await
async function makeRequests() {
    try{
        const response2 = await fetch('http://jsonplaceholder.typicode.com/todos/1');
        const jasonResponse1 = await response2.json()
        console.log(jasonResponse1);
    } catch (error) {
        console.error(error);
    } finally {
        console.log('finally!');
    }
}

makeRequests()