let proxy;

const open = document.getElementById('open');
open.onclick = function() {
    const fe = 'top = 200, left = 450, width = 300, height =200'
    proxy = window.open('./one.html', "open", fe)
    console.log('1 ', proxy.close);
}

const focus = document.getElementById('focus');
focus.onclick = function() {
    proxy.focus()
    console.log('focus() 실행');
}

//focus 실행시 열였던 창이 앞으로 나옴

const two = document.getElementById('two');
two.onclick = function() {
    const fe = 'top = 200, left = 450, width = 300, height = 300'
    proxy = window.open('./one.html', "two", fe)
}

const three = document.getElementById('three');
three.onclick = function() {
    proxy.focus()
    console.log('focus() 실행');
    const timeout = setTimeout(() => {
        proxy.blur();
        console.log('blur 실행')
        clearTimeout(timeout);
    }, 3000);
}