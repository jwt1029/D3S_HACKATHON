function passwordCompare() {

	//비밀번호 비교
	var password = document.getElementById('user_pw_signUp');
	var passwordAgain = document.getElementById('user_pw_again');

	if (password.value != passwordAgain.value) {//비밀번호와 비밀번호 확인이 일치하지 않으면
		Materialize.toast('password mismatched!', 4000);
		return;
	}

	//빈 공간 체크
	var userID = document.getElementById('user_id_signUp');
	var name = document.getElementById('user_pw_signUp');
	var schoolName = document.getElementById('school_name');
	var schoolGrade = document.getElementById('school_grade');
	var schoolClass = document.getElementById('school_class');
	var schoolNumber = document.getElementById('school_number');

	if (userID.value == "" ||
		password.value == "" ||
		passwordAgain.value == "" ||
		name.value == "" ||
		schoolName.value == "" ||
		schoolGrade.value == "" ||
		schoolClass.value == "" ||
		schoolNumber.value == "") { //빈 입력칸이 있는지 검사
		Materialize.toast('Please insert all input fields!', 4000);
		return;
	}

	//TODO
}