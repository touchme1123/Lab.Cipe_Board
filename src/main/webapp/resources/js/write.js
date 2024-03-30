// 필요한 엘리멘트들
const categoryWrite = document.body;
const material = document.getElementById("material");
const dishName = document.getElementById("dishName");
const recipeText = document.getElementById("recipeText");
const dishImg = document.getElementById("dishImg");
const saveBtn = document.getElementById("saveBtn");
const writeModalLabel = document.getElementById("writeModalLabel");
// 필요한 엘리멘트들

// 글쓰기 해야할 것 객체 생성 함수 만들고 onClick함수 안에 공란 입력 방지,
// 새로운 값의 id 생성, 객체 생성, 객체 생성 확인함수를 이용해서 생성 확인,
// 인풋 폼에 값들 비워주기
// 객체 생성 함수
// 객채의 프로퍼티는 recipeId, material, dishName, recipeText, dishImg
// 객체 안의 값은 recipeId, categoryId, material, dishName, recipeText, dishImg, writeDate
// 객체 안에 필요한 함수는 showRecipe
// showRecipe함수는 작성한 값을 확인하기 위한용도로 console.log()를 이용해서 객체 값 확인

let recipeCount = 0; //레시피 마다 고유 id 부여
let categoryId = categoryWrite.id; //현재 카테고리위치 확인

// 작성 시점의 날짜 얻기
let today = new Date();
let year = today.getFullYear();
let month = ("0" + (today.getMonth() + 1)).slice(-2);
let day = ("0" + today.getDate()).slice(-2);
let writeDate = year + "-" + month + "-" + day;
// 작성 시점의 날짜 얻기

// 객체 생성 함수
function Recipe(recipeId, material, dishName, recipeText, dishImg) {
  this.recipeId = recipeId;
  this.material = material;
  this.dishName = dishName;
  this.recipeText = recipeText;
  this.dishImg = dishImg;
  this.category = categoryId; //카테고리 별로 저장되게
  this.writeDate = writeDate;
  this.showRecipe = function () {
    // 객채 생성확인 나중에는 db에 전송으로 바꿈
    console.log(
      "새 래시피의 아이디는 " +
        this.recipeId +
        "이며 카태고리는 " +
        this.category +
        "이며 요리이름은 " +
        this.dishName +
        "이며 재료는 " +
        this.material +
        "이며 레시피는 " +
        this.recipeText +
        "이며 사진주소는 " +
        this.dishImg +
        "이며 작성 시점은 " +
        this.writeDate +
        "입니다."
    );
  };
}
// 객체 생성 함수

// 글입력시 현재 어느 카테고리에 있는지 알려주기위함.
window.addEventListener("DOMContentLoaded", function () {
  //현재 페이지가 로드되면 작업 바로 시작
  if (categoryId === "westernFood") {
    writeModalLabel.innerText = "새 양식 레시피";
  } else if (categoryId == "koreanFood") {
    writeModalLabel.innerText = "새 한식 레시피";
  } else if (categoryId == "chineseFood") {
    writeModalLabel.innerText = "새 중식 레시피";
  } else if (categoryId == "japaneseFood") {
    writeModalLabel.innerText = "새 일식 레시피";
  }
});
// 글입력시 현재 어느 카테고리에 있는지 알려주기위함.

// 글 쓰기 안에 저장 버튼이 눌렸을 때
function onClick() {
  // 공란 입력 방지
  if (dishName.value == "") {
    alert("요리 이름을 입력해주세요.");
  } else if (material.value == "") {
    alert("재료를 입력해주세요.");
  } else if (recipeText.value == "") {
    alert("레시피를 입력해주세요.");
  } else {
    recipeCount++; // id가 될 넘버를 생성

    // 객체 생성
    let newRecipe = new Recipe(
      recipeCount,
      material.value,
      dishName.value,
      recipeText.value,
      dishImg.value
    );
    // 객체 생성

    newRecipe.showRecipe(); // 객채 생성확인 나중에는 db에 전송으로 바꿈

    //인풋에 값 클리어
    material.value = "";
    dishName.value = "";
    recipeText.value = "";
    dishImg.value = "";
    //인풋에 값 클리어
  }
}
saveBtn.addEventListener("click", onClick);
// 글 쓰기 안에 저장 버튼이 눌렸을 때
