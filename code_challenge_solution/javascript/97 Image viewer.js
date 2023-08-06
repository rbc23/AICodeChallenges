const images = ["image1.jpg", "image2.jpg", "image3.jpg"];

let currentIndex = 0;

function displayImage(index) {
  const imageContainer = document.getElementById("image-container");
  
  imageContainer.innerHTML = "";
  
  const imageElement = document.createElement("img");
  imageElement.src = images[index];
  
  imageContainer.appendChild(imageElement);
}

function nextImage() {
  currentIndex = (currentIndex + 1) % images.length;
  displayImage(currentIndex);
}

function previousImage() {
  currentIndex = (currentIndex - 1 + images.length) % images.length;
  displayImage(currentIndex);
}

displayImage(currentIndex);

document.getElementById("next-btn").addEventListener("click", nextImage);
document.getElementById("previous-btn").addEventListener("click", previousImage);