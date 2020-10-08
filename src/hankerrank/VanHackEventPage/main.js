let currentEvent = {};

//CONSTANT EVENT TYPE
const MEET_UP = "Meet Up";
const LEAP = "Leap";
const RECRUTING_MISSION = "Recruiting Mission";
const VANHACKATON = "VanHackathon";
const PREMIUM_ONLY = "PREMIUM<br/>ONLY";
const OPENWEBINAR = "Open Webinar";

//ENUM TO EVENTYPE
EventType = Object.freeze({
  MEETUP: MEET_UP,
  LEAP: LEAP,
  RECRUTING: RECRUTING_MISSION,
  VANHACKATON: VANHACKATON,
  PREMIUM_ONLY: PREMIUM_ONLY,
  OPEN4ALL: OPENWEBINAR,
});

//EVENTS TO FILL THE PAGE
const events = [
  {
    title: "Premium Class Vanhack",
    locale: "Online",
    date: "Octuber 26, 2020",
    cover:
      "https://images.unsplash.com/photo-1530025809667-1f4bcff8e60f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1540&q=80",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore officiis aut, quisquam quas obcaecati ut? Perferendis, dolores assumenda.",
    longDescription:
      "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laborum dolores reprehenderit vero neque iure hic ratione ea totam, deserunt repellat.<br/><br/>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Deserunt, temporibus.     Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ad fugit, error rerum iste cupiditate ratione, esse quas ducimus perspiciatis ex, ipsa harum nesciunt facilis! Architecto, reprehenderit deserunt! Eveniet, eius sapiente facere ut natus, saepe, tenetur expedita officia laudantium eum explicabo consequatur. Enim error at tempore esse. Aliquid reiciendis labore tenetur.",
    type: EventType.PREMIUM_ONLY,
  },
  {
    title: "Premium Mock Interview",
    locale: "Online",
    date: "Octuber 30, 2020",
    cover:
      "https://images.unsplash.com/photo-1497493292307-31c376b6e479?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore officiis aut, quisquam quas obcaecati ut? Perferendis, dolores assumenda.",
    longDescription:
      "Lorem ipsum dolor sit amet.<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Porro iste ipsam explicabo sint quibusdam repellendus harum, rerum recusandae quos accusamus exercitationem ullam quas eaque tempora eius corrupti officia eveniet ratione omnis cum aperiam incidunt eligendi hic! Eaque dolore officia corporis?<br/><br/>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nam libero autem deserunt eum maiores quidem, sit aliquam sint vitae. Laudantium, a quia nihil sit, officia neque corrupti mollitia consequatur debitis ipsam nostrum praesentium expedita at enim quibusdam? Quasi dicta totam, porro animi, iste illo eligendi architecto sint velit exercitationem quam mollitia ratione repudiandae laborum modi ad minima repellat temporibus, pariatur est aperiam ducimus voluptas. Recusandae dignissimos ullam consectetur autem quis iure eligendi rem laborum vitae vel nobis quidem culpa, impedit voluptatem quam molestiae ab beatae facere minus laudantium, sint eius odio tempore? Soluta, quos dignissimos assumenda deserunt accusantium tempora fugit!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias repudiandae quia voluptate impedit provident assumenda?",
    type: EventType.PREMIUM_ONLY,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Montreal",
    date: "Octuber 25, 2020",
    cover:
      "https://images.unsplash.com/photo-1508693926297-1d61ee3df82a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi inventore quia aliquid blanditiis mollitia et explicabo?",
    longDescription:
      "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptas sit vero similique iste, voluptatem incidunt deleniti earum rem impedit quibusdam amet necessitatibus repellendus? Ab assumenda excepturi nihil accusamus iure, temporibus, tenetur harum sit eligendi nisi eveniet dolore recusandae soluta, sapiente commodi. Accusamus iste eveniet veritatis expedita aliquam nostrum iure pariatur earum labore eum excepturi quo praesentium, at quia asperiores aperiam adipisci necessitatibus ex, cupiditate fugit nisi magni minima culpa deleniti? Corporis, blanditiis. Porro id ipsum laudantium nihil obcaecati laborum fuga error sapiente, ullam reiciendis illo ducimus quidem, perferendis reprehenderit optio ex rem voluptatum minus sequi illum! Enim eaque perspiciatis minus dolorum veritatis laudantium quis labore, dolores nisi quibusdam a veniam. Magni corporis delectus assumenda numquam esse, praesentium mollitia temporibus iusto sed eaque incidunt et dolores culpa nobis quia minus hic quam impedit excepturi ex voluptatem placeat sapiente eos. Quos totam accusantium excepturi non, enim eum voluptate in soluta fugiat quod vel numquam debitis! Ratione non quidem enim ipsum soluta, consequuntur veritatis molestias ipsam perspiciatis animi officiis hic laborum illum quibusdam, explicabo amet. Ullam officiis error unde aspernatur excepturi enim reiciendis nobis illo accusamus repellendus magnam velit, nisi eos a quidem assumenda fugiat laudantium itaque ipsum. Totam quod neque eum quia?",
    type: EventType.MEETUP,
  },
  {
    title: "Leap together",
    locale: "Online",
    date: "Octuber 27, 2020",
    cover:
      "https://images.unsplash.com/photo-1573496267526-08a69e46a409?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1349&q=80",
    description:
      "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sunt deleniti expedita cum nesciunt autem.",
    longDescription:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit, assumenda!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident, cumque!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repudiandae, error beatae. Sint amet perferendis assumenda cupiditate fugiat provident reprehenderit eligendi sunt temporibus itaque, veritatis officia ducimus, deserunt tenetur. Quibusdam, magnam?<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse repellendus saepe nihil reiciendis, ad quidem minima cupiditate sed sapiente aut! Saepe ipsam nemo, dignissimos inventore voluptas doloremque quia. Veniam hic incidunt in. Ducimus voluptas, ut sint expedita eligendi distinctio adipisci?<br/><br/>Lorem ipsum dolor sit amet.<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo, eaque!",
    type: EventType.LEAP,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Toronto",
    date: "Octuber 29, 2020",
    cover:
      "https://images.unsplash.com/photo-1517245386807-bb43f82c33c4?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit accusantium, tenetur exercitationem quam ullam sint aperiam aut praesentium.",
    longDescription:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit, assumenda!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident, cumque!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repudiandae, error beatae. Sint amet perferendis assumenda cupiditate fugiat provident reprehenderit eligendi sunt temporibus itaque, veritatis officia ducimus, deserunt tenetur. Quibusdam, magnam?<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse repellendus saepe nihil reiciendis, ad quidem minima cupiditate sed sapiente aut! Saepe ipsam nemo, dignissimos inventore voluptas doloremque quia. Veniam hic incidunt in. Ducimus voluptas, ut sint expedita eligendi distinctio adipisci?<br/><br/>Lorem ipsum dolor sit amet.<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo, eaque!",
    type: EventType.RECRUTING,
  },
  {
    title: "Ready for Challenge?",
    locale: "Online",
    date: "November 9, 2020",
    cover:
      "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis ratione, provident vitae eum error nobis!",
    longDescription:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit, assumenda!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident, cumque!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repudiandae, error beatae. Sint amet perferendis assumenda cupiditate fugiat provident reprehenderit eligendi sunt temporibus itaque, veritatis officia ducimus, deserunt tenetur. Quibusdam, magnam?<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse repellendus saepe nihil reiciendis, ad quidem minima cupiditate sed sapiente aut! Saepe ipsam nemo, dignissimos inventore voluptas doloremque quia. Veniam hic incidunt in. Ducimus voluptas, ut sint expedita eligendi distinctio adipisci?<br/><br/>Lorem ipsum dolor sit amet.<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo, eaque!",
    type: EventType.VANHACKATON,
  },
  {
    title: "Network is the Key",
    locale: "Online",
    date: "November 16, 2020",
    cover:
      "https://images.unsplash.com/photo-1551818255-e6e10975bc17?ixlib=rb-1.2.1&auto=format&fit=crop&w=1525&q=80",
    description:
      "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Mollitia aperiam est, dolores incidunt maiores officiis magnam enim beatae nulla! Enim?",
    longDescription:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit, assumenda!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident, cumque!<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repudiandae, error beatae. Sint amet perferendis assumenda cupiditate fugiat provident reprehenderit eligendi sunt temporibus itaque, veritatis officia ducimus, deserunt tenetur. Quibusdam, magnam?<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse repellendus saepe nihil reiciendis, ad quidem minima cupiditate sed sapiente aut! Saepe ipsam nemo, dignissimos inventore voluptas doloremque quia. Veniam hic incidunt in. Ducimus voluptas, ut sint expedita eligendi distinctio adipisci?<br/><br/>Lorem ipsum dolor sit amet.<br/><br/>Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo, eaque!",
    type: EventType.OPEN4ALL,
  },
];

function eventClasse(event) {
  const type = event.type;

  if (type === EventType.PREMIUM_ONLY) {
    return 1;
  } else if (
    type === EventType.LEAP ||
    type === EventType.RECRUTING_MISSION ||
    type === EventType.VANHACKATON
  ) {
    return 2;
  }
  return 3;
}

//STARTUP SCRIPT BEFORE LOAD
function startup() {
  const listEvents = document.getElementById("events");
  events.forEach((event) => {
    let eventCard = createCard(event);

    eventCard.addEventListener("click", () => {
      const modal = document.getElementById("modal");
      currentEvent = event;
      fillContentModal(modal, event);
      openModal(modal, event);
    });
    listEvents.appendChild(eventCard);
  });
}

function createCard(event) {
  //Create left block with calendar and date
  const leftDiv = createLeftDivCard(event);

  //Create middle block with title and some text
  const middleDiv = createMiddleDivCard(event);

  //Create right block with premium flag and
  const cardDetails = createRightDivCard(event);

  //Create and mount the event card

  const card = document.createElement("DIV");
  card.classList.add("card");
  card.appendChild(leftDiv);
  card.appendChild(middleDiv);
  card.appendChild(cardDetails);
  return card;
}

function createLeftDivCard(event) {
  const iconCalendar = document.createElement("I");
  iconCalendar.classList.add("fa");
  iconCalendar.classList.add("fa-calendar");
  const dateSpan = document.createElement("SPAN");
  dateSpan.classList.add("publication-details");
  dateSpan.classList.add("date");
  dateSpan.innerHTML = event.date;

  const imageDataDiv = document.createElement("DIV");
  imageDataDiv.classList.add("background-image");
  imageDataDiv.appendChild(iconCalendar);
  imageDataDiv.appendChild(dateSpan);

  const cardImage = document.createElement("DIV");
  cardImage.classList.add("image-data");
  cardImage.appendChild(imageDataDiv);

  return cardImage;
}

function createMiddleDivCard(event) {
  const title = document.createElement("DIV");
  title.classList.add("title");
  title.innerHTML = event.title;

  const iconMap = document.createElement("I");
  iconMap.classList.add("fa");
  iconMap.classList.add("fa-map-marker");
  const locale = document.createElement("SPAN");
  locale.innerHTML = event.locale;
  const subtitle = document.createElement("DIV");
  subtitle.classList.add("subtitle");
  subtitle.appendChild(iconMap);
  subtitle.appendChild(locale);

  const description = document.createElement("DIV");
  description.classList.add("description");
  let shortDesc = event.description;
  if (shortDesc.length > 170) {
    shortDesc = shortDesc.substring(0, 150) + "...";
  }
  description.innerHTML = shortDesc;

  const cardData = document.createElement("DIV");
  cardData.classList.add("post-data");
  cardData.appendChild(title);
  cardData.appendChild(subtitle);
  cardData.appendChild(description);

  return cardData;
}

function createRightDivCard(event) {
  const premiumFlag = document.createElement("SPAN");

  const eventClass = eventClasse(event);

  premiumFlag.classList.add("event-class" + eventClass);
  premiumFlag.innerHTML = event.type;

  const svgPremium = document.getElementById("premium-svg");
  const clonePremium = svgPremium.cloneNode(true);

  const linkCta = document.createElement("A");
  linkCta.innerHTML = "Read More &rarr;";

  const cta = document.createElement("DIV");
  cta.classList.add("cta");
  cta.appendChild(linkCta);

  const flag = document.createElement("DIV");
  flag.classList.add("flag");

  if (event.type === EventType.PREMIUM_ONLY) {
    flag.appendChild(clonePremium);
  }
  flag.appendChild(premiumFlag);

  const cardDetails = document.createElement("DIV");
  cardDetails.classList.add("details");

  cardDetails.appendChild(flag);
  cardDetails.appendChild(cta);

  return cardDetails;
}

startup();

/* MODAL CONFIRMATION REGISTRATION */
const registerBtn = document.getElementById("register-btn");
registerBtn.addEventListener("click", () => {
  if (!isCurrentEventPremium()) {
    const confirmationModal = document.querySelector("#modal-success");
    const modal = document.querySelector(".modal");
    closeModal(modal);
    fillConfirmationModal(confirmationModal, currentEvent);
    openModal(confirmationModal);
  } else {
    const erroModal = document.querySelector("#modal-error");
    const modal = document.querySelector(".modal");
    closeModal(modal);
    openModal(erroModal);
  }
});

function fillConfirmationModal(modal, event) {
  if (!modal) return;
}

function isCurrentEventPremium() {
  if (currentEvent && currentEvent.type === EventType.PREMIUM_ONLY) {
    return true;
  }
  return false;
}

/* END MODAL CONFIRMATION REGISTRATION*/

/* MODAL LOGIC OPEN AND CLOSE*/
const closeModalButtons = document.querySelectorAll("[data-close-button]");
const closeModalInfoButtons = document.querySelectorAll(
  "[data-close-modal-info]"
);
const overlay = document.getElementById("overlay");

overlay.addEventListener("click", () => {
  const modals = document.querySelectorAll(".modal.active");
  modals.forEach((modal) => {
    closeModal(modal);
  });
});

closeModalButtons.forEach((button) => {
  button.addEventListener("click", () => {
    const modal = button.closest(".modal");
    closeModal(modal);
  });
});

closeModalInfoButtons.forEach((button) => {
  button.addEventListener("click", () => {
    const modal = button.closest(".modal-info");
    closeModal(modal);
  });
});

function fillContentModal(modal, event) {
  if (!modal) return;

  const modalTitle = document.getElementById("modal-title");
  modalTitle.innerHTML = event.title;

  const modalCover = document.getElementById("modal-cover");
  modalCover.style.backgroundImage = "url('" + event.cover + "')";

  const eventType = document.createElement("SPAN");

  let title =
    "http://www.facebook.com/sharer.php?u=https%3A%2F%2Fwww.vanhack.com&p[title]=" +
    event.title.replace(" ", "+");
  document.getElementById("face-anchor").setAttribute("href", title);
  title =
    "https://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwww.vanhack.com&title=Vanhack+Event" +
    event.title.replace(" ", "+");
  document.getElementById("link-anchor").setAttribute("href", title);
  title =
    "http://twitter.com/share?text=Vanhack+Event&url=https%3A%2F%2Fwww.vanhack.com" +
    event.title.replace(" ", "+");
  document.getElementById("twit-anchor").setAttribute("href", title);

  const modalLocale = document.getElementById("modal-locale");
  modalLocale.innerHTML = event.locale;

  const modalDate = document.getElementById("modal-date");
  modalDate.innerHTML = event.date;

  const modalDescription = document.getElementById("modal-body");
  modalDescription.innerHTML = event.longDescription;
}

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
