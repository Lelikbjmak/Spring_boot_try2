
function sendRequest(method, url, body = null) {
  return new Promise((resolve, reject) => {
    const xhr = new XMLHttpRequest()

    xhr.open(method, url)

    xhr.responseType = 'json'
    xhr.setRequestHeader('Content-Type', 'application/json')

    xhr.onload = () => {
        resolve(xhr.response)
      }

    xhr.onerror = () => {
      resolve(xhr.response)
    }

    xhr.send(JSON.stringify(body))
  })
}


function addtype(){
var str = document.getElementByID("string").value;
var anint = document.getElementByID("int").value;
var adate = document.getElementByID("date").value;

alert("Start");

sendRequest("POST", "/Home/addtype" {
string: str,
anInt: anint,
date: adate
})

alert("Successful!");
}


function gettype(){

}