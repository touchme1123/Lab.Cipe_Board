// 박현수 추가
//삭제 recipe_id
function removeRecipe(url, recipe_id) {
	console.log(url);
	console.log(recipe_id);
	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	var recipeNOInput = document.createElement("input");
	recipeNOInput.setAttribute("type", "hidden");
	recipeNOInput.setAttribute("name", "recipe_id");
	recipeNOInput.setAttribute("value", recipe_id);

	form.appendChild(recipeNOInput);
	document.body.appendChild(form);
	form.submit();
};
//삭제
//수정
function modifyRecipe(obj) {
	console.log("클릭");
	console.log(document.frmRecipe);
	obj.action = "/myapp/board/modifyRecipe.do";

	obj.submit();
};
//수정

//카테고리 체크
function countCheck(obj) {
	const checkboxes
		= document.getElementsByName("recipe_category");
	checkboxes.forEach((cb) => {
		cb.checked = false;
	})
	obj.checked = true;
}
// 박현수 추가