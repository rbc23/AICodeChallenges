```javascript
const images = [
  'image1.jpg',
  'image2.jpg',
  'image3.jpg',
  'image4.jpg',
  'image5.jpg'
];

const viewer = document.getElementById('image-viewer');
const prevBtn = document.getElementById('prev-button');
const nextBtn = document.getElementById('next-button');

let currentIndex = 0;

function showImage() {
  viewer.src = images[currentIndex];
}

function prevImage() {
  currentIndex = (currentIndex - 1 + images.length) % images.length;
  showImage();
}

function nextImage() {
  currentIndex = (currentIndex + 1) % images.length;
  showImage();
}

prevBtn.addEventListener('click', prevImage);
nextBtn.addEventListener('click', nextImage);

showImage();
```