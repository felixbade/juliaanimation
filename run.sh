java -cp "$(dirname $0)/.." julia8/Main &&
nice -n 19 ffmpeg -i images/julia_fractal_%d.png -vf scale=-1:720 -codec:v libx264 -preset veryslow -threads 8 -an julia8.avi
