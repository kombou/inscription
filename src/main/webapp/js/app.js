const gethttrequest = function(){
    var httprequest;

    if(window.XMLHttpRequest){
        httprequest = new XMLHttpRequest();
        if(httprequest.overrideMimeType){
            httprequest.overrideMimeType('text/html');
        }
    }else if (window.ActiveXObject){
        try {
            httprequest = new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e){
            try {
                httprequest = new ActiveXObject("Microsoft.XMLHTTP");
            }catch (e){}
        }
    }
    if(!httprequest){
        alert("abandon :( impossible de creer une instance XMLHTTP");

        return  false;
    }
    return httprequest;
}

const  save = document.querySelector('.save');
const form = document.querySelector('.form')
const data = new FormData(form);

save.addEventListener('click',function (e){
    e.preventDefault();
    const httprequest = gethttrequest();
    httprequest.onreadystatechange = function (){
        if(httprequest.readyState === 4){
            if(httprequest.status === 200){
                var results = (httprequest.responseText);
                alert(results);
            }
        }
    }
    httprequest.open('POST',form.getAttribute('action'),true);
    httprequest.send(data);
},false);