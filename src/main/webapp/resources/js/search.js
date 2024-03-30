

// 필요한 엘리멘트들

const ul = document.getElementById("recipeUl");
const editModal = document.getElementById("editModal");
const editForm = document.getElementById("editForm");
const editClose = document.getElementById("editClose");
const editModalLabel = document.getElementById("editModalLabel");
const editDishName = document.getElementById("editDishName");
const editMaterial = document.getElementById("editMaterial");
const editRecipeText = document.getElementById("editRecipeText");
const editDishImg = document.getElementById("editDishImg");
const editSaveBtn = document.getElementById("editSaveBtn");
const moveModal = document.getElementById("moveModal");
const moveForm = document.getElementById("moveForm");
const moveClose = document.getElementById("moveClose");
const moveKorean = document.getElementById("moveKorean");
const moveWestern = document.getElementById("moveWestern");
const moveJapanese = document.getElementById("moveJapanese");
const moveChinese = document.getElementById("moveChinese");
const deleteModal = document.getElementById("deleteModal");
const deleteForm = document.getElementById("deleteForm");
const deleteClose = document.getElementById("deleteClose");
const deleteYes = document.getElementById("deleteYes");
const categoryRead = document.body;
// 필요한 엘리멘트들

// 글 보여주기 //////////////////////////////////////////////////
// 지정된 엘리멘트 -> showDishName(h2), recipeContent(div), dishImg(img), recipeText(div), showMaterial(p), showRecipe(p), showDate(p)
// 엘리멘트간의 상속 관계 괄호 안이 자식 괄호 밖이 부모
// recipe(showDishName), recipe(recipeContent, showDate), recipeContent(dishImg, recipeText), recipeText(showMaterial, showRecipe)
// 지정된 엘리먼트를 만듬, 엘리먼트에 클레스 이름을 부여, 엘리먼트 안의 택스트를 부여,

// 삭제
// 삭제 버튼이 클릭되면 삭제 모달이 보이게
// 삭제 모달의 닫기 버튼이 클릭되면 삭제 모달이 안보이게
// 삭제 모달에 삭제 버튼이 클릭되면 레시피 배열에서 현재 클릭한 레시피의 아이디와 동일한 아이디의 레시피만 찾아서 삭제

// 서치
//

let categoryReadId = categoryRead.id; // 카테고리 확인용
let nowRecipeId; // 현재 클릭한 레시피의 아이디
let checkedNum = recipeArr.filter((e) => e.bookmark).length; // 북마크 클릭 횟수 카운트 용

window.addEventListener("DOMContentLoaded", function() {
	for (let i = 0; i < recipeArr.length; i++) {

			let dishNameBtn = document.createElement("button");
			dishNameBtn.className = "dishNameBtn";
			dishNameBtn.id = recipeArr[i].recipeId;
			dishNameBtn.innerText = recipeArr[i].dishName;
			ul.appendChild(dishNameBtn);

			let recipeList = document.createElement("li");
			recipeList.className = "recipeList";
			recipeList.id = `recipeList${recipeArr[i].recipeId}`;
			recipeList.style.display = "none";
			ul.appendChild(recipeList);

			dishNameBtn.addEventListener("click", dishNameBtnClick);

			// 닫히는 애니메이션
			function dishNameBtnClick() {
				if (recipeList.style.display === "flex") {
					recipeList.style.animation = "fadeInUp 1s";
					dishNameBtn.style.animation = "changeClose 1s";

					setTimeout(function() {
						recipeList.style.display = "none";
					}, 800);
					dishNameBtn.style.backgroundColor = "white";
					dishNameBtn.style.color = "black";
					dishNameBtn.style.borderRadius = "10px";
					dishNameBtn.style.margin = "5px 0";
				} else {
					recipeList.style.display = "flex";
					recipeList.style.animation = "fadeInDown 1s";
					dishNameBtn.style.animation = "changeOpen 1s";
					setTimeout(function() {
						dishNameBtn.style.backgroundColor = "#f2b705";
						dishNameBtn.style.color = "#f2b705";
					}, 800);
					dishNameBtn.style.borderRadius = "10px 10px 0 0";
					dishNameBtn.style.margin = "0";
				}
			}
			// 닫히는 애니메이션

			let recipe = document.createElement("div");
			recipe.className = "showRecipe";
			recipeList.appendChild(recipe);

			// 북마크 ////////////////////////////////////////////
			let recipeHead = document.createElement("div");
			recipeHead.className = "recipeHead";
			recipe.appendChild(recipeHead);

			let bookmarkLabel = document.createElement("span");
			bookmarkLabel.className = "bookmarkLabel";
			bookmarkLabel.innerText = "즐겨찾기";
			recipeHead.appendChild(bookmarkLabel);

			let bookmark = document.createElement("input");
			bookmark.className = "bookmark";
			bookmark.type = "checkbox";
			recipeHead.appendChild(bookmark);

			bookmark.addEventListener("click", bookmarkChecked);

			if (recipeArr[i].bookmark) {
				bookmark.setAttribute("checked", "checked");
			}

			function bookmarkChecked() {
				nowRecipeId = recipeArr[i].recipeId;
				if (recipeArr[i].bookmark) {
					recipeArr[i].bookmark = false;
					checkedNum--;
				} else {
					if (checkedNum < 3) {
						if (nowRecipeId === recipeArr[i].recipeId) {
							recipeArr[i].bookmark = true;
							checkedNum++;
						}
					} else {
						alert("즐겨찾기는 3개 이하만 가능합니다.");
						bookmark.checked = false;
					}
				}
				console.log(checkedNum);
				console.log(recipeArr);
			}
			// 북마크 ////////////////////////////////////////////

			// 글 보여주기 //////////////////////////////////////////////////
			let showDishName = document.createElement("h2");
			showDishName.className = "showDishName";
			showDishName.innerText = recipeArr[i].dishName;
			recipe.appendChild(showDishName);

			let recipeContent = document.createElement("div");
			recipeContent.className = "recipeContent";
			recipe.appendChild(recipeContent);

			let dishImg = document.createElement("img");
			dishImg.className = "dishImg";
			dishImg.src = recipeArr[i].dishImg;
			recipeContent.appendChild(dishImg);

			let recipeText = document.createElement("div");
			recipeText.className = "recipeText";
			recipeContent.appendChild(recipeText);

			let showMaterial = document.createElement("p");
			showMaterial.className = "showMaterial";
			showMaterial.innerText = "재료 : " + recipeArr[i].material;
			recipeText.appendChild(showMaterial);

			let showRecipe = document.createElement("p");
			showRecipe.className = "showRecipe";
			showRecipe.innerText = "조리 방법 : " + recipeArr[i].recipeText;
			recipeText.appendChild(showRecipe);

			let showDate = document.createElement("p");
			showDate.className = "showDate";
			showDate.innerText = recipeArr[i].writeDate;
			recipe.appendChild(showDate);
			// 글 보여주기 //////////////////////////////////////////////////

			// 버튼 //////////////////////////////////////////
			let btns = document.createElement("div");
			btns.className = "btns";
			recipe.appendChild(btns);

			let moveBtn = document.createElement("button");
			moveBtn.className = "btn btn-dark";
			moveBtn.id = `moveBtn${categoryReadId}`;
			moveBtn.innerText = "이동";
			btns.appendChild(moveBtn);

			let editBtn = document.createElement("button");
			editBtn.className = "btn btn-dark";
			editBtn.id = `editBtn${categoryReadId}`;
			editBtn.type = "button";
			editBtn.innerText = "수정";
			btns.appendChild(editBtn);

			let deleteBtn = document.createElement("button");
			deleteBtn.className = "btn btn-dark";
			deleteBtn.id = `deleteBtn${categoryReadId}`;
			deleteBtn.innerText = "삭제";
			btns.appendChild(deleteBtn);
			// 버튼 //////////////////////////////////////////

			//이동 //////////////////////////////////////////////////
			moveBtn.addEventListener("click", moveClick);
			function moveClick() {
				moveModal.style.display = "flex";
				moveModal.style.animation = "fadeIn 0.5s";
				moveForm.style.animation = "open 0.5s";
				nowRecipeId = recipeArr[i].recipeId;
				console.log(recipeArr[i].recipeId);
			}

			moveKorean.addEventListener("click", moveKoreanClick);
			function moveKoreanClick() {
				if (recipeArr[i].recipeId === nowRecipeId) {
					recipeArr[i].category = "koreanFood";
				}
				console.log(recipeArr);
				moveModal.style.animation = "fadeOut 0.5s";
				moveForm.style.animation = "close 0.5s";
				setTimeout(function() {
					moveModal.style.display = "none";
				}, 400);
			}

			moveWestern.addEventListener("click", moveWesternClick);
			function moveWesternClick() {
				if (recipeArr[i].recipeId === nowRecipeId) {
					recipeArr[i].category = "westernFood";
				}
				console.log(recipeArr);
				moveModal.style.animation = "fadeOut 0.5s";
				moveForm.style.animation = "close 0.5s";
				setTimeout(function() {
					moveModal.style.display = "none";
				}, 400);
			}

			moveJapanese.addEventListener("click", moveJapaneseClick);
			function moveJapaneseClick() {
				if (recipeArr[i].recipeId === nowRecipeId) {
					recipeArr[i].category = "japaneseFood";
				}
				console.log(recipeArr);
				moveModal.style.animation = "fadeOut 0.5s";
				moveForm.style.animation = "close 0.5s";
				setTimeout(function() {
					moveModal.style.display = "none";
				}, 400);
			}

			moveChinese.addEventListener("click", moveChineseClick);
			function moveChineseClick() {
				if (recipeArr[i].recipeId === nowRecipeId) {
					recipeArr[i].category = "chineseFood";
				}
				console.log(recipeArr);
				moveModal.style.animation = "fadeOut 0.5s";
				moveForm.style.animation = "close 0.5s";
				setTimeout(function() {
					moveModal.style.display = "none";
				}, 400);
			}

			moveClose.addEventListener("click", moveCloseClick);
			function moveCloseClick() {
				console.log(recipeArr);
				moveModal.style.animation = "fadeOut 0.5s";
				moveForm.style.animation = "close 0.5s";
				setTimeout(function() {
					moveModal.style.display = "none";
				}, 400);
			}
			//이동 //////////////////////////////////////////////////

			// 수정 //////////////////////////////////////////////////
			editBtn.addEventListener("click", editClick);
			function editClick() {
				editModal.style.display = "flex";
				editModal.style.animation = "fadeIn 0.5s";
				editForm.style.animation = "open 0.5s";
				nowRecipeId = recipeArr[i].recipeId;
				editModalLabel.innerText = recipeArr[i].dishName + " 레시피 수정";
				editDishName.innerText = recipeArr[i].dishName;
				editMaterial.innerText = recipeArr[i].material;
				editRecipeText.innerText = recipeArr[i].recipeText;
				editDishImg.innerText = recipeArr[i].dishImg;
				console.log(recipeArr[i].dishName);
				console.log(nowRecipeId);
			}

			editClose.addEventListener("click", editCloseClick);
			function editCloseClick() {
				editModal.style.animation = "fadeOut 0.5s";
				editForm.style.animation = "close 0.5s";
				setTimeout(function() {
					editModal.style.display = "none";
				}, 400);
			}

			editSaveBtn.addEventListener("click", editSaveClick);
			function editSaveClick() {
				if (recipeArr[i].recipeId === nowRecipeId) {
					recipeArr[i].dishName = editDishName.value;
					recipeArr[i].material = editMaterial.value;
					recipeArr[i].recipeText = editRecipeText.value;
					recipeArr[i].dishImg = editDishImg.value;
				}
				console.log(recipeArr);
				editModal.style.animation = "fadeOut 0.5s";
				editForm.style.animation = "close 0.5s";
				setTimeout(function() {
					editModal.style.display = "none";
				}, 400);
			}
			// 수정 //////////////////////////////////////////////////

			// 삭제 //////////////////////////////////////////////////
			//민영님 코드
			deleteBtn.addEventListener("click", deleteClick);
			function deleteClick() {
				deleteModal.style.display = "flex";
				deleteModal.style.display = "flex";
				deleteModal.style.animation = "fadeIn 0.5s";
				deleteForm.style.animation = "open 0.5s";
				const elementId =
					event.target.parentElement.parentElement.querySelector(".showId");
				deletePostId = parseInt(elementId.innerText);
				console.log(deletePostId);
			}

			deleteClose.addEventListener("click", function() {
				deleteModal.style.animation = "fadeOut 0.5s";
				deleteForm.style.animation = "close 0.5s";
				setTimeout(function() {
					deleteModal.style.display = "none";
				}, 400);
			});

			deleteYes.addEventListener("click", function() {
				recipeArr = recipeArr.filter((ele) => ele.recipeId !== deletePostId);
				deleteModal.style.animation = "fadeOut 0.5s";
				deleteForm.style.animation = "close 0.5s";
				setTimeout(function() {
					deleteModal.style.display = "none";
				}, 400);
				console.log(recipeArr);
			});
			//민영님 코드
			// 삭제 //////////////////////////////////////////////////
	}

	// 슬라이드에서 클릭한 레시피가 열리게 ////////
	if (window.localStorage.length > 0) {
		console.log(window.localStorage.getItem("id"));
		document
			.getElementById(window.localStorage.getItem("id"))
			.scrollIntoView({ behavior: "smooth" });
		document.getElementById(window.localStorage.getItem("id")).click();
		window.localStorage.clear();
	}
	// 슬라이드에서 클릭한 레시피가 열리게 ////////
});
