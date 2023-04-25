const url = "http://localhost:9090/api/reembolso/";


function GET() {
    return fetch(url, {
        method: "GET"
    })
        .then(response => response.json());
}
function POST(data) {

    const options = {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    };

    return fetch(url, options)
        .then(response => response.json());

}
function PATCH(data, id) {
    const urls = url + "atualizarReembolsado/"+ id;

    const options = {
        method: 'PATCH',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    };
    return fetch(urls, options)
        .then(response => response.json());
}
