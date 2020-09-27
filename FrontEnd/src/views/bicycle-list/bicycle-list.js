require('./bicycle-list.scss');

require('bootstrap');
require('../../js/scrolling');

import {fillTable} from './fill-table';
import {fillPagination} from './fill-table';

let sortBy = 'PRICE_UP', bicycleType = 'ALL', pageNumber = 1;

window.addEventListener('load', function () {
    const url = "/bicycles/all/sort/" + sortBy + "/type/" + bicycleType + "/page/" + pageNumber;
    getBicyclesFromServer(url);
})

function getBicyclesFromServer(url) {
    $.get(url, function (data) {
        let dataObject = JSON.parse(data);
        fillTable(dataObject.bicycles || []);
        fillPagination(dataObject.totalPages, dataObject.currentPage);
    })
}

document.getElementById('dropdownSort2').addEventListener('change', function (e) {
    const value = e.target.value;
    if (value) {
        sortBy = value;
        pageNumber = 1;
        const url = "/bicycles/all/sort/" + sortBy + "/type/" + bicycleType + "/page/" + pageNumber;
        getBicyclesFromServer(url);
    }
})

$('#dropdownType').change(e => {
    const value = e.target.value;
    if (value) {
        bicycleType = value;
        pageNumber = 1;
        const url = "/bicycles/all/sort/" + sortBy + "/type/" + bicycleType + "/page/" + pageNumber;
        getBicyclesFromServer(url);
    }
})

export function navActions() {
    $('#previousButton').click(() => {
        if (pageNumber > 1) {
            pageNumber--;
            const url = "/bicycles/all/sort/" + sortBy + "/type/" + bicycleType + "/page/" + pageNumber;
            console.log("previous", url);
            getBicyclesFromServer(url);
        }
    })
    $('#nextButton').click(() => {
        pageNumber++;
        const url = "/bicycles/all/sort/" + sortBy + "/type/" + bicycleType + "/page/" + pageNumber;
        console.log("next", url);
        getBicyclesFromServer(url);
    })
}