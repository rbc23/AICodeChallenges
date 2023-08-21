using System;
using System.Collections.Generic;

namespace ImageViewer
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> images = new List<string>();

            // Add sample images to the list
            images.Add("image1.jpg");
            images.Add("image2.jpg");
            images.Add("image3.jpg");

            // Display the images
            DisplayImages(images);
        }

        static void DisplayImages(List<string> imageList)
        {
            foreach (string image in imageList)
            {
                Console.WriteLine("Displaying image: " + image);
            }
        }
    }
}