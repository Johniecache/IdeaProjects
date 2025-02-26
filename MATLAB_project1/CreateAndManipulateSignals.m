fname = 'cicada-72075.mp3';
[x,y] = audioread(fname);

reversed = flip(x);

rereversed = flip(reversed);

t = (0:length(x)-1) / y;

plot(t,rereversed);
xlabel('Time (s)');
ylabel('Amplitude');
title('Cicada, Sound of Fall');
grid on;

saveas(gcf,'rereversed_plotted_audio.jpg');

sound(rereversed, y);