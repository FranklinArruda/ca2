document.addEventListener("DOMContentLoaded", function() {

  function showTableBody() {
      let tableBody = document.querySelector('.table-body');
      tableBody.style.display = 'table-row-group'; // 'table-row-group' is used to properly display the tbody element
  }

  // Calling function after 4 seconds (4000 milliseconds)
  setTimeout(showTableBody, 2500);




  // ---- HOME PAGE ---
  // Delay and show welcoome message
  function showHeroPageMessage() {
      let HeroPageMessage = document.querySelector('#hero-content');
      HeroPageMessage.style.display = 'block';
  }
  // calling function after delay
  setTimeout(showHeroPageMessage, 2500);


  // Hides and Show element on hover
  function show(element) {
      element.classList.add('show');
      element.classList.remove('hide');
  };

  // it hides message when 'hover' is out
  function hide(element) {
      element.classList.remove('show');
      element.classList.add('hide');
  };




  //---------  FULL NAME   ---------------
  // It gets elements (icon and message on hover)
  const uploadIcons = document.querySelectorAll('.full-name-container .button');
  const uploadMessages = document.querySelectorAll('.full-name-container .name');

  // event listener with for each loop that TRIGERS both ICON's (Credentials and Phone System)
  // loop through class of the icon for both system
  uploadIcons.forEach((uploadIcon, index) => {

      //when mouse (hover over)
      uploadIcon.addEventListener('mouseover', event => {
          show(uploadMessages[index]); // it adds message
      });

      // when mouse (hover is out)
      uploadIcon.addEventListener('mouseout', event => {
          hide(uploadMessages[index]); // it hides message
      });


  });




  // SCROLL BUTTON
  const scrollUpBtn = document.querySelector(".scrollUpBtn");

  function showScrollUpBtn() {
      if (window.scrollY > 375) {
          scrollUpBtn.classList.remove("hide");
          scrollUpBtn.classList.add("show");
      } else {
          scrollUpBtn.classList.remove("show");
          scrollUpBtn.classList.add("hide");
      }
  }

  // Add event listener to run the function when scrolling
  window.addEventListener("scroll", showScrollUpBtn);

  // Call the function initially to show/hide the button based on the initial scroll position
  showScrollUpBtn();




});