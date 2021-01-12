async function getAllDevelopers() {
	try {
		const response = await axios.get('/developers');
		let developers = response.data;

		let tr_html = "";		
		for (let i = 0; i < developers.length; i++){
			tr_html = tr_html + "<tr>";
			tr_html = tr_html + "<td>" + developers[i].id + "</td>"
			tr_html = tr_html + "<td>" + developers[i].firstname + "</td>"
			tr_html = tr_html + "<td>" + developers[i].lastname + "</td>"
			tr_html = tr_html + "<td>" + developers[i].email + "</td>"
			tr_html = tr_html + "<td>" + developers[i].startContract + "</td>"
			tr_html = tr_html + "</tr>";
		}

		u('table').append(tr_html);	
	} catch (error) {
		console.error(error);
	}
}

getAllDevelopers();