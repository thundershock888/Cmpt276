 // Your web app's Firebase configuration/*
 var firebaseConfig = {
  apiKey: "AIzaSyAyZFD38P5DS_6_RUSLGjAbbAjce3neO90",
  authDomain: "login-9a731.firebaseapp.com",
  projectId: "login-9a731",
  storageBucket: "login-9a731.appspot.com",
  messagingSenderId: "25737172393",
  appId: "1:25737172393:web:4166bfdeff7ebe47fce0b8"
};

firebase.initializeApp(firebaseConfig);

//make auth & firestore reference;
const auth = firebase.auth();
const db = firebase.firestore();

//firestore settings
db.settings({merge: true});

function checkSearch() {
  if(window.location.href.indexOf("pie?name") > -1) 
  {
var x = document.getElementById("searching");
if (x.style.display === "none") {
x.style.display = 'block';
}else {
x.style.display ='none';
}
  }

}
// adapted from https://www.youtube.com/c/TheNetNinja/videos
// listen for auth status changes
auth.onAuthStateChanged(user => {
  if (user) {
    console.log('user logged in: ', user.email);
            if (user.email == 'admin@gmail.com') {
              console.log('user logged in: adm', user.email);
              db.collection('admin-info').get().then(snapshot => {
              setupadminInfo(snapshot.docs);
              }, err=>{
                console.log(err.message)
              });
            } else {
              setupadminInfo([]);
            }
    db.collection('infos').get().then(snapshot => {
      setupinfos(snapshot.docs);
      setupView(user);
    }, err=>{
      console.log(err.message)
    });
  }  
  else {
    setupView();
    console.log('user logged out');
    setupinfos([]);
    setupadminInfo([]);
  }
})

// signup
const signupForm = document.querySelector('#signup-form');
signupForm.addEventListener('submit', (e) => {
  e.preventDefault();
  
  // get user info
  const email = signupForm['signup-email'].value;
  const password = signupForm['signup-password'].value;

  // sign up the user
  auth.createUserWithEmailAndPassword(email, password).then(cred => {
    //add user lol id
    return db.collection('users').doc(cred.user.uid).set({
      lolid: signupForm['signup-lolid'].value
    });
  }).then(()=>{
    // close the signup modal & reset form
    const modal = document.querySelector('#modal-signup');
    M.Modal.getInstance(modal).close();
    signupForm.reset();
    signupForm.querySelector('.error').innerHTML='';
  }).catch(err=>{
    signupForm.querySelector('.error').innerHTML=err.message;
  });
});

// logout
const logout = document.querySelector('#logout');
logout.addEventListener('click', (e) => {
  e.preventDefault();
  auth.signOut();
});

// login
const loginForm = document.querySelector('#login-form');
loginForm.addEventListener('submit', (e) => {
  e.preventDefault();
  
  // get user info
  const email = loginForm['login-email'].value;
  const password = loginForm['login-password'].value;

  // log the user in
  auth.signInWithEmailAndPassword(email, password).then((cred) => {
    // close the signup modal & reset form
    const modal = document.querySelector('#modal-login');
    M.Modal.getInstance(modal).close();
    loginForm.reset();
    loginForm.querySelector('.error').innerHTML='';
  }).catch(err=>{
    loginForm.querySelector('.error').innerHTML=err.message;
  });

});

