let proxy;

const one = document.getElementById('one');
one.onclick = function() {
    const fe = 'top = 200, left = 450, width = 300, height =200'
    proxy = window.open('./one.html', "", fe)
    console.log('1 ', proxy.close);
}

const two = document.getElementById('two');
two.onclick = function() {
    proxy.close()
    console.log('2 ', proxy.close);
}

const three = document.getElementById('three');
three.onclick = function() {
    proxy = window.open('', 'three')
    console.log('1 ', proxy.close);
    console.log('2 ', proxy.name);
}

const four = document.getElementById('four');
four.onclick = function() {
    proxy.close()
    console.log('3 ', proxy.close);
    console.log('4 ', proxy.name);
}