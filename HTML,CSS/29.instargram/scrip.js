const toggleThemeBtn = document.querySelector('.header-theme-button');

document.onload = setIntervalTheme(localStorage.getItem('theme'));
function setIntervalTheme(themeKey){
    if(themeKey == 'dark'){
        document.documentElement.classList.add('darkTheme');
    }
    else{
        document.documentElement.classList.remove('darkTheme')
    }
}

toggleThemeBtn.addEventListener('click', () => {
    document.documentElement.classList.toggle('darkTheme');

    if(document.documentElement.classList.contains('darkTheme')){
        localStorage.setItem('theme', 'dark')
    } else{
        localStorage.setItem('theme', 'light')
    }
});
