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
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore officiis aut, quisquam quas obcaecati ut? Perferendis, dolores assumenda.",
    longDescription: "",
    type: EventType.PREMIUM_ONLY,
  },
  {
    title: "Premium Mock Interview",
    locale: "Online",
    date: "Octuber 30, 2020",
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore officiis aut, quisquam quas obcaecati ut? Perferendis, dolores assumenda.",
    longDescription: "",
    type: EventType.PREMIUM_ONLY,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Montreal",
    date: "Octuber 25, 2020",
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi inventore quia aliquid blanditiis mollitia et explicabo?",
    longDescription: "",
    type: EventType.MEETUP,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Online",
    date: "Octuber 27, 2020",
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sunt deleniti expedita cum nesciunt autem.",
    longDescription: "",
    type: EventType.LEAP,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Toronto",
    date: "Octuber 29, 2020",
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit accusantium, tenetur exercitationem quam ullam sint aperiam aut praesentium.",
    longDescription: "",
    type: EventType.RECRUTING,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Online",
    date: "November 9, 2020",
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis ratione, provident vitae eum error nobis!",
    longDescription: "",
    type: EventType.VANHACKATON,
  },
  {
    title: "Trial Premium Webinar",
    locale: "Online",
    date: "November 16, 2020",
    cover: "./resource/headway-F2KRf_QfCqw-unsplash.jpg",
    description:
      "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Mollitia aperiam est, dolores incidunt maiores officiis magnam enim beatae nulla! Enim?",
    longDescription: "",
    type: EventType.OPEN4ALL,
  },
];

//STARTUP SCRIPT BEFORE LOAD
function startup() {
  const listEvents = document.getElementById("events");
  events.forEach((event) => {
    let eventCard = createCard(event);

    eventCard.addEventListener("click", () => {
      const modal = document.getElementById("modal");
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
  if (event.type === EventType.PREMIUM_ONLY) {
    premiumFlag.classList.add("premium-flag");
  } else {
    premiumFlag.classList.add("no-premium-event");
  }
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

/**/
/* MODAL LOGIC OPEN AND CLOSE*/
const closeModalButtons = document.querySelectorAll("[data-close-button]");
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

function openModal(modal, event) {
  if (modal == null) return;
  const modalTitle = document.getElementById("modal-title");
  modalTitle.innerHTML = event.title;

  const modalCover = document.getElementById("modal-cover");
  modalCover.style.backgroundImage = "url('" + event.cover + "')";

  const modalLocale = document.getElementById("modal-locale");
  modalLocale.innerHTML = event.locale;

  modal.classList.add("active");
  overlay.classList.add("active");
}

function closeModal(modal) {
  if (modal == null) return;
  modal.classList.remove("active");
  overlay.classList.remove("active");
}
/* MODAL END*/
