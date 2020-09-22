import {getBicycleTemplate} from './bicycle-item-template.js';
import {getPaginationTemplate} from './pagination-template.js';

window.addEventListener('load', function () {
    getBicyclesFromServer("/bicycleList/all");
})

function getBicyclesFromServer(url) {
    $.get(url, function (data) {
        let dataObject = JSON.parse(data);
        fillTable(dataObject.bicycles || []);
        // fillTable(data.bicycles || []);
        fillPagination(dataObject.totalPages, dataObject.currentPage);
    })
}


function fillTable(bicycles) {
    let bicyclesItems = '';
    // перебераем полученный список велосипедов из JSON, вставляем данные в шалбончик
    (bicycles || []).forEach(bicycle => {
        bicyclesItems += getBicycleTemplate(bicycle)
    })
    // находим на странице div для вставки в него велосипедов
    const bicyclesList = document.getElementById('bicyclesList');
    // вставляем все велисипеды в div
    bicyclesList.innerHTML = bicyclesItems;
}

function fillPagination(totalPages, currentPage) {
    let paginationItems = getPaginationTemplate(totalPages, currentPage);
    const pagination = document.getElementById('paginationId');
    pagination.innerHTML = paginationItems;
}


