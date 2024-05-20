// used tutorial by www.w3schools.com to implement filter using jQuery

$(document).ready(function(){

  $("#fish_input").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#fish_table tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });

  $("#sea_creature_input").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#sea_creature_table tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });

  $("#bug_input").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#bug_table tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });

});