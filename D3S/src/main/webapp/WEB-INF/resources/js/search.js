var cnt = 0;

function addKeyword(event) {
	var inputKeyword = document.getElementById('inputKeyword'); //검색어 인풋 필드
	var category = document.getElementById('category'); //검색어 인풋 필드
	var keywordList = document.getElementById('keywordList');
	var count = document.getElementById('count');

	if (event.keyCode === 13) { //enter가 입력되면
		console.log(inputKeyword.value);
		console.log(category.options[category.selectedIndex].text);
		console.log(keywordList);

		cnt++;
		count.value = cnt;

		keywordList.innerHTML +=
		'<input name="data' + cnt + //데이터
		'"' + 'hidden="hidden"' +
		'value="' + category.options[category.selectedIndex].text +
		":" + inputKeyword.value + '">' +

		'<div class="chip">' + //뷰
		category.options[category.selectedIndex].text +
		" : " + inputKeyword.value +
		'<i class="close material-icons">close</i>' +
		'</div>';

		inputKeyword.value = "";
	}	
}

function search() {

}