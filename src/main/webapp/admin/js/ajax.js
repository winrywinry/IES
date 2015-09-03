//ajax2.js
//패키지정의
//var ajax = new Object();
//ajax.xhr  = new Object();
var ajax = {};
ajax.xhr = {};

//Request클래스 정의
ajax.xhr.Request=function(url,params,callback,method){
	this.url=url;
	this.params=params;
	this.callback=callback;
	this.method=method;
	this.send();
}   

ajax.xhr.Request.prototype = {
	getXMLHttpRequest : function() {
		if (window.ActiveXObject) { // 브라우저에서 ActiveXObject를 지원한다면(IE)
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		} else if (window.XMLHttpRequest) { // 비 IE
			return new XMLHttpRequest();
		} else { // XMLHttpRequest 객체를 지원하지 않는 경우
			return null;
		}
	},
	send : function() {
		this.xhr = this.getXMLHttpRequest(); //Request 멤버속성 xhr 정의
		var httpMethod = this.method ? this.method : "GET";
		// 삼항 연산자 (조건식) ? A : B
		if (httpMethod != "GET" && httpMethod != "POST") {
			httpMethod = "GET"
		}

		var httpParams = (this.params == null || this.params == "") ? null : this.params;

		var httpUrl = this.url;
		if (httpMethod == "GET" && httpParams != null) {
			httpUrl = httpUrl + "?" + httpParams;
		}
		this.xhr.open(httpMethod, httpUrl, true);
		this.xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		var request = this; //Request
		this.xhr.onreadystatechange = function(){
			request.onStateChange.call(request);
			//call(this) ----> this : onStateChange
		}
		this.xhr.send(httpMethod == "POST" ? httpParams : null);
	},
	onStateChange : function() {
		this.callback(this.xhr); //callback 프로퍼티에 할당된 함수를 호출하면서 xhr 객체를 넘겨라!!
	}
}
