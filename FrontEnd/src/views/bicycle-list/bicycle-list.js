require('./bicycle-list.scss');

require('bootstrap');
require('../../js/scrolling');

import {fillTable} from './fill-table';
import {fillPagination} from './fill-table';

window.addEventListener('load', function () {
  getBicyclesFromServer("/bicycles/all/page/1");
})

function getBicyclesFromServer (url) {
  $.get(url, function (data) {
    let dataObject = JSON.parse(data);
    fillTable(dataObject.bicycles || []);
    fillPagination(dataObject.totalPages, dataObject.currentPage);
  })
}

