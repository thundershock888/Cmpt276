// adapted from https://www.youtube.com/c/TheNetNinja/videos
//DOM elements
const infoList = document.querySelector('.infos');
const adminOnly = document.querySelector('.admin-info');
const loggedOutLinks = document.querySelectorAll('.logged-out');
const loggedInLinks = document.querySelectorAll('.logged-in');
const accountDet = document.querySelector('.account-det');
const searchingDet = document.querySelectorAll('.searching');

const setupView = (user)=>{
    if(user){
      //show acc info
      db.collection('users').doc(user.uid).get().then(doc=>{
          const html = `
          <div>Logged in as ${user.email}</div>
          <div>Associated League Account ID ${doc.data().lolid}</div>
        `;
        accountDet.innerHTML = html;
      })
    
        loggedInLinks.forEach(bar =>bar.style.display = 'block');
        loggedOutLinks.forEach(bar =>bar.style.display ='none'); //hide
    }else{
        //hide acc info
        accountDet.innerHTML = '';
        loggedInLinks.forEach(bar =>bar.style.display = 'none'); //hide
        loggedOutLinks.forEach(bar =>bar.style.display ='block'); 
    }
}

// setup infos
const setupinfos = (data) => {

  if (data.length) {
    let html = '';
    data.forEach(doc => {
      const info = doc.data();
      const li = `
        <li>
          <div class="collapsible-header grey lighten-4"> ${info.title} </div>
          <div class="collapsible-body white"> ${info.content} </div>
        </li>
      `;
      html += li;
    });
    infoList.innerHTML = html
  } else {
    infoList.innerHTML = '<h5 class="center-align container grey "> <br> Login to view more info <p> </p> <br></h5>';
  }
  

};

// setup admin-info
const setupadminInfo = (data) => {

  if (data.length) {
    let html = '';
    data.forEach(doc => {
      const info = doc.data();
      const li = `
        <li>
          <div class="collapsible-header grey lighten-4"> ${info.AdminView} </div>
          <div class="collapsible-body white"> ${info.Admincontent} </div>
        </li>
      `;
      html += li;
    });
    adminOnly.innerHTML = html
  } else {
    adminOnly.innerHTML = '<h5 class="center-align container grey "> <br> Restricted <p> </p> <br></h5>';
  }

};


// setup materialize components
document.addEventListener('DOMContentLoaded', function() {

  var modals = document.querySelectorAll('.modal');
  M.Modal.init(modals);

  var ite = document.querySelectorAll('.collapsible');
  M.Collapsible.init(ite);
  

});

function showSearchTable(){
  var x = document.getElementById("searching");
  if (x.style.display === "none") {
    x.style.display = 'block';
    }else {
      x.style.display ='none';
    }
  }