  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyAyZFD38P5DS_6_RUSLGjAbbAjce3neO90",
    authDomain: "login-9a731.firebaseapp.com",
    projectId: "login-9a731",
    storageBucket: "login-9a731.appspot.com",
    messagingSenderId: "25737172393",
    appId: "1:25737172393:web:4166bfdeff7ebe47fce0b8"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);


  const auth = firebase.auth();

  function signUp(){

    var email = document.getElementById("email");
    var password = document.getElementById("password");

    const promise = auth.createUserWithEmailAndPassword(email.value, password.value);
    promise.catch(e=>alert(e.message));

    alert("Signed Up");
  }

  function signIn(){
    var email = document.getElementById("email");
    var password = document.getElementById("password");

    const promise = auth.signInWithEmailAndPassword(email.value, password.value);
    promise.catch(e=>alert(e.message));
    
    
    //take to another page
  }

  function signOut(){
    
    auth.signOut();
    alert("Signed Out");
  }

  auth.onAuthStateChanged(function(user)){
      if(user){
          var email = user.email;
          alert("user " + email);
      }else{
          alert("No Active user");
      }
  }