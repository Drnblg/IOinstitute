var twww = []
for (var i = 1; i < 101; i++) {
    twww.push(Math.floor(Math.random() * 100))
}
console.log(twww);
twww.sort(function (a, b) { return b - a });
console.log(twww);