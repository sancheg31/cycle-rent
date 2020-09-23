export const getBicycleTemplate =
  ({
     id = '',
     name = '',
     type = '',
     weight = 0,
     price = 0,
     description = '',
     photo = '',
     photoAlt = '',
     availability = false
   }) =>
    `<div class="col mb-4">
        <div class="card h-100 border-my">
          <a href="bicycle?id=${id}">
            <img src="/img/bicycles/${photo}" class="card-img-top" alt="${photoAlt}">
            <div class="card-body">
              <h5 class="card-title">${name}</h5>
              <h6 class="card-title card-price ${!availability ? 'text-danger' : ''}">${availability ? price + ' $/per hour' : 'Unavailable'} </h6>
              <p class="card-text">${description}</p>
              <ul class="bicycle-info-list">
                <li><em class="fas fa-check"></em> ${type}</li>
                <li><em class="fas fa-check"></em> ${weight} kg</li>
              </ul>
            </div>
          </a>
        </div>
      </div>`;
