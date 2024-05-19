
window.addEventListener('DOMContentLoaded', () => {
    let scrollPos = 0;
    const mainNav = document.getElementById('mainNav');
    const headerHeight = mainNav.clientHeight;
    window.addEventListener('scroll', function() {
        const currentTop = document.body.getBoundingClientRect().top * -1;
        if ( currentTop < scrollPos) {
            // Scrolling Up
            if (currentTop > 0 && mainNav.classList.contains('is-fixed')) {
                mainNav.classList.add('is-visible');
            } else {
                console.log(123);
                mainNav.classList.remove('is-visible', 'is-fixed');
            }
        } else {
            // Scrolling Down
            mainNav.classList.remove(['is-visible']);
            if (currentTop > headerHeight && !mainNav.classList.contains('is-fixed')) {
                mainNav.classList.add('is-fixed');
            }
        }
        scrollPos = currentTop;

    });
})
function zoomImage(img) {
    var modal = document.getElementById("imageModal");
    var modalImg = document.getElementById("zoomedImg");
    modal.style.display = "block";
    modalImg.src = img.src;
}

function closeModal() {
    var modal = document.getElementById("imageModal");
    modal.style.display = "none";
}

// Function to display the popup
function showPopup() {
    document.getElementById("popup").style.display = "block";
}

// Function to close the popup
function closePopup() {
    document.getElementById("popup").style.display = "none";
}

// Attach a click event listener to the submit button
document.getElementById("submitBtn").addEventListener("click", function() {
    showPopup();
    // Here, you can add the code to handle the submission (e.g., AJAX request to the backend).
});





