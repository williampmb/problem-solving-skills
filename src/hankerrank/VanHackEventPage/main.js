function startup() {
  const listEvents = document.getElementById("events");
  const event = createCard();
  const event1 = createCard();
  listEvents.appendChild(event);
  listEvents.appendChild(event1);
}

function newElement(element, className) {
  return document.createElement(element).classList.add(className);
}

function createCard(event) {
  //Create left block with calendar and date
  const iconCalendar = document.createElement("I");
  iconCalendar.classList.add("fa");
  iconCalendar.classList.add("fa-calendar");
  const dateSpan = document.createElement("SPAN");
  dateSpan.classList.add("publication-details");
  dateSpan.classList.add("date");
  dateSpan.innerHTML = " March 30, 2020";

  const imageDataDiv = document.createElement("DIV");
  imageDataDiv.classList.add("background-image");
  imageDataDiv.appendChild(iconCalendar);
  imageDataDiv.appendChild(dateSpan);

  const cardImage = document.createElement("DIV");
  cardImage.classList.add("image-data");
  cardImage.appendChild(imageDataDiv);

  //Create middle block with title and some text

  const title = document.createElement("DIV");
  title.classList.add("title");
  title.innerHTML = "Artificial Inteligente";

  const subtitle = document.createElement("DIV");
  subtitle.classList.add("subtitle");
  subtitle.innerHTML = "Ut sed metus et nunc aliquam porta";

  const description = document.createElement("DIV");
  description.classList.add("description");
  description.innerHTML =
    "Cras in risus nisi. Fusce feugiat diam nunc, sit amet interdum ligula vehicula vitae. Sed gravida turpis at purus volutpat";

  const cardData = document.createElement("DIV");
  cardData.classList.add("post-data");
  cardData.appendChild(title);
  cardData.appendChild(subtitle);
  cardData.appendChild(description);

  //Create right block with premium flag and details

  const premiumFlag = document.createElement("SPAN");
  premiumFlag.classList.add("premium-flag");
  premiumFlag.innerHTML = "PREMIUM";

  const svgPremium = document.getElementById("premium-svg");
  const clonePremium = svgPremium.cloneNode(true);

  const linkCta = document.createElement("A");
  linkCta.innerHTML = "Read More &rarr;";

  const cta = document.createElement("DIV");
  cta.classList.add("cta");
  cta.appendChild(linkCta);

  const flag = document.createElement("DIV");
  flag.appendChild(premiumFlag);
  flag.appendChild(clonePremium);

  const cardDetails = document.createElement("DIV");
  cardDetails.classList.add("details");

  cardDetails.appendChild(flag);
  cardDetails.appendChild(cta);

  //Create and mount the event card

  const card = document.createElement("DIV");
  card.classList.add("card");
  card.appendChild(cardImage);
  card.appendChild(cardData);
  card.appendChild(cardDetails);
  return card;
}

startup();

/**/
/* MODAL LOGIC OPEN AND CLOSE*/
const openModalButtons = document.querySelectorAll("[data-modal-target]");
const closeModalButtons = document.querySelectorAll("[data-close-button]");
const overlay = document.getElementById("overlay");

overlay.addEventListener("click", () => {
  const modals = document.querySelectorAll(".modal.active");
  modals.forEach((modal) => {
    closeModal(modal);
  });
});
openModalButtons.forEach((button) => {
  button.addEventListener("click", () => {
    const modal = document.querySelector(button.dataset.modalTarget);
    openModal(modal);
  });
});

closeModalButtons.forEach((button) => {
  button.addEventListener("click", () => {
    const modal = button.closest(".modal");
    closeModal(modal);
  });
});

function openModal(modal) {
  if (modal == null) return;
  modal.classList.add("active");
  overlay.classList.add("active");
}

function closeModal(modal) {
  if (modal == null) return;
  modal.classList.remove("active");
  overlay.classList.remove("active");
}
/* MODAL END*/
