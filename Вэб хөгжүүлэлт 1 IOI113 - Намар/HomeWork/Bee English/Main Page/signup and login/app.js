const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});




function check(form)/*function to check userid & password*/ {
  /*the following code checkes whether the entered userid and password are matching*/
  if (form.userName.value == "drnblg" && form.pswrd.value == "Duuren100131") {
    window.open('../homePage.html')/*opens the target page while Id & password matches*/
  }
  else {
    alert("Error Password or Username")/*displays error message*/
  }
}
