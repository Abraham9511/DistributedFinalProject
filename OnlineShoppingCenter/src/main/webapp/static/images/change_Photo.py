import Image,sys
image_path = sys.argv[1]
print(image_path)
img = Image.open(image_path)
new_img = img.resize((900, 400), Image.ANTIALIAS)
new_img.save(image_path, quality=100)
