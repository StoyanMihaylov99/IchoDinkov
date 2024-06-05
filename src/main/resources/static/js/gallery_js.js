document.addEventListener("DOMContentLoaded", function() {
    fetch('/images')
        .then(response => response.json())
        .then(imageNames => {
            const gallery = document.getElementById('gallery');
            imageNames.forEach(imageName => {
                const img = document.createElement('img');
                img.src = `/images/${imageName}`;
                img.alt = imageName;
                gallery.appendChild(img);
            });
        })
        .catch(error => console.error('Error fetching images:', error));
});
