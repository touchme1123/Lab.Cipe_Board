

let carousel1 = document.getElementById("carousel1");
let carousel2 = document.getElementById("carousel2");
let carousel3 = document.getElementById("carousel3");


window.addEventListener("DOMContentLoaded", function showCarousel() {
  console.log(bookmarkArr[0]);
  carousel1.style.backgroundImage = `url(${bookmarkArr[0]})`;
  carousel2.style.backgroundImage = `url(${bookmarkArr[1]})`;
  carousel3.style.backgroundImage = `url(${bookmarkArr[2]})`;
});
