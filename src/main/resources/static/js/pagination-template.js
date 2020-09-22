// import {getBicyclesFromServer} from './bicycle-list';

export const getPaginationTemplate =
  (totalPages = 1, currentPage = 1) =>
    `<nav>
  <ul class="pagination pagination-lg justify-content-center my-pagination">
    <li class="page-item ${currentPage === 1 ? 'disabled' : ''}">
      <a class="page-link" href="/bicycles/all/page/${currentPage - 1}" tabindex="-1" aria-disabled="true">Previous</a>
    </li>
    <li class="page-item page-number"> ${currentPage}/${totalPages} </li>
    <li class="page-item ${currentPage === totalPages ? 'disabled' : ''}">
      <a class="page-link" href="/bicycles/all/page/${currentPage + 1}">Next</a>
    </li>
  </ul>
</nav>
`;
