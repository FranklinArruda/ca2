


  function showTableBody() {
      let tableBody = document.querySelector('.table-body');
      tableBody.style.display = 'table-row-group'; // 'table-row-group' is used to properly display the tbody element
  }

  // Calling function after 4 seconds (4000 milliseconds)
    setTimeout(showTableBody, 1500);
