var cnt = 0;

function addKeyword(event) {
	var inputKeyword = document.getElementById('inputKeyword'); //검색어 인풋 필드
	var category = document.getElementById('category'); //검색어 인풋 필드
	var keywordList = document.getElementById('keywordList');
	var count = document.getElementById('count');

	if (event.keyCode === 13) { //enter가 입력되면

		if (inputKeyword.value == "") {
			Materialize.toast('Please insert keyword!', 4000);
			return false;
		}

		console.log(inputKeyword.value);
		console.log(category.options[category.selectedIndex].text);
		console.log(keywordList);

		cnt++;
		count.setAttribute("value", cnt);

		keywordList.innerHTML +=
		'<input name="data' + cnt + //데이터
		'"' + 'hidden="hidden"' +
		'value="' + category.options[category.selectedIndex].id +
		":" + inputKeyword.value + '">' +

		'<div class="chip">' + //뷰
		category.options[category.selectedIndex].text +
		" : " + inputKeyword.value +
		'<i class="close material-icons">close</i>' +
		'</div>';

		inputKeyword.value = "";
	}
}

function showList() {
	var studentList = document.getElementById('studentList');

	if (studentList.innerHTML == "") {
		studentList.innerHTML +=
		'<thead>' +
		'<tr>' +
		'<th data-field="name">이름</th>' +
		'<th data-field="school_name">학교</th>' +
		'<th data-field="school_name">학년</th>' +
		'<th data-field="school_name">반</th>' +
		'<th data-field="school_name">번호</th>' +
		'</tr>' +
		'</thead>' +
		'<tbody>';
	}
	//학생 리스트 출력 (학생 수 많큼)
	// <tr>
	// 	            <td>Alvin</td>
	// 	            <td>Alvin</td>
	// 	            <td>Eclair</td>
	// 	            <td>$0.87</td>
	// 	            <td>$7.00</td>
	// 	          </tr>
	studentList.innerHTML += '</tbody>';
}