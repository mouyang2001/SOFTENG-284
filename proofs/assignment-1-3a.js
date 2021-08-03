console.clear();
console.log( "\nRunning assignment-1-3a.js" );

let n = 8;
let count = 0;

for (let i = 1; i <= n; i = i * 2) {
  for (let j = 0; j < n; j++) {
    if (i == j) {
      for (let k = 1; k < n ** 3; k += n) {
        count++;
      }
    } else {
      count++;
    }
  }
}

let pastTutorialAnswer = (Math.floor(Math.log(n) / Math.log(2)) + 1) * (n ** 2 + (n - 1));
let rayAnswer = (n ** 2 - 1) * Math.ceil(Math.log(n) / Math.log(2)) + n * (Math.log(n) / Math.log(2) + 1);

console.log("\nCalculated elementary operations = " + count);
console.log("\nTutorial answer prediction = " + pastTutorialAnswer);
console.log("Raymond answer prediction = " + rayAnswer);

if (count == rayAnswer) {
  console.log("\nRaymond is correct! 🙌 🧠")
} else if (count === pastTutorialAnswer) {
  console.log("\nPast Turial answer correct!😂");
} else {
  console.log("\nNo one correct");
}


