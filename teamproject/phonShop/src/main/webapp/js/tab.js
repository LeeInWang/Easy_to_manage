function openTab(evt, infom){
    let tabPage, tablinks ;
    // tabPage = document.querySelector('.tabPage');
    tabPage = document.getElementsByClassName('tabPage');
    tablinks = document.getElementsByClassName('tablinks');

    for(let i=0; i<tabPage.length; i++){
        tabPage[i].style.display = 'none';
    }

    for(let i=0; i<tablinks.length; i++){
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
     document.getElementById(infom).style.display = 'block';
     evt.currenTarget.className +=" avtive";
}