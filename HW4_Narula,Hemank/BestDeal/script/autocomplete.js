function init() {
	completeField = document.getElementById("searchId");
	completeTable = document.getElementById("complete-table");
	autoRow = document.getElementById("auto-row");
}

function doCompletion() {

	var url = "http://localhost/BestDeal/Home?action=complete&searchId="
			+ escape(searchId.value);

	$.ajax({
		url : url,
		success : function(data) {
			parseMessages(data)
		}
	});
}

function appendProduct(productName, productId, productType) {
	var row;
	var cell;
	var linkElement;
	completeTable.style.display = 'table';
	row = document.createElement("tr");
	cell = document.createElement("td");
	row.appendChild(cell);
	completeTable.appendChild(row);

	cell.className = "popupCell";
	linkElement = document.createElement("a");
	linkElement.className = "popupItem";

	debugger;
	if (productType == 'Laptop') {
		linkElement.setAttribute("href",
				"http://localhost/BestDeal/LaptopList?prodId=" + productId);
	
	} else if (productType == 'Phone') {
		linkElement.setAttribute("href",
				"http://localhost/BestDeal/SmartPhoneList?prodId=" + productId);
	
	} else if (productType == 'Tablet') {
		linkElement.setAttribute("href",
				"http://localhost/BestDeal/TabletList?prodId=" + productId);
		
	
	} else if (productType == 'Television') {
		linkElement.setAttribute("href",
				"http://localhost/BestDeal/TelevisionList?prodId=" + productId);
		
	}

	linkElement.appendChild(document.createTextNode(productName));
	cell.appendChild(linkElement);
}

function parseMessages(responseXML) { // no matches returned
	if (responseXML == null) {
		return false;
	} else {
		clearTable();
		var products = responseXML.getElementsByTagName("products")[0];
		if (products.childNodes.length > 0) {
			completeTable.setAttribute("bordercolor", "black");
			completeTable.setAttribute("border", "1");
			for (loop = 0; loop < products.childNodes.length; loop++) {
				var product = products.childNodes[loop];
				var productName = product.getElementsByTagName("productName")[0];
				var productId = product.getElementsByTagName("id")[0];
				var productType = product.getElementsByTagName("prodType")[0];
				appendProduct(productName.childNodes[0].nodeValue,
						productId.childNodes[0].nodeValue,
						productType.childNodes[0].nodeValue);
			}
		}
	}
}

function callback() {
	clearTable();
	if (req.readyState == 4) {
		if (req.status == 200) {
			parseMessages(req.responseXML);
		}
	}
}
function clearTable() {
	if (completeTable.getElementsByTagName("tr").length > 0) {
		completeTable.style.display = 'none';
		for (loop = completeTable.childNodes.length - 1; loop >= 0; loop--) {
			completeTable.removeChild(completeTable.childNodes[loop]);
		}
	}
}
