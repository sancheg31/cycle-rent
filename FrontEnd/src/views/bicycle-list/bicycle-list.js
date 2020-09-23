require('./bicycle-list.scss');

require('bootstrap');
require('../../js/scrolling');

import {fillTable} from './fill-table';
import {fillPagination} from './fill-table';

window.addEventListener('load', function () {
  getBicyclesFromServer("/json/bicycles.json");
})

function getBicyclesFromServer (url) {
  $.get(url, function (data) {
    console.log("type of data:", typeof (data));
    fillTable(data.bicycles || []);
    fillPagination(data.totalPages, data.currentPage);
  })
}

