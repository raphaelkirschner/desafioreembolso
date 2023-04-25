const url = window.location.protocol + "//" + window.location.host + "/" + "api/reembolso/";

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
function PUT(id, isReembolsado) {
    const urls = url + "atualizar/" + id + "/" + isReembolsado;

    return fetch(urls, {
        method: "PUT"
    })
        .then(response => response.json());
}
