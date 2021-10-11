console.clear();
console.log( "\nRunning assignment-1-3a.js" );

let n = 512;
let count = 0;

for (let i = 1; i <= n; i = i * 2) {
  for (let j = 0; j < n; j++) {
    if (i == j) {
      for (let k = 1; k < n**3; k += n) {
        count++;
      }
    } else {
      count++;
    }
  }
}

let pastTutorialAnswer = (Math.floor(Math.log(n) / Math.log(2))+1) * (n**2 + (n - 1));
let danielAnswer = (Math.ceil(Math.log(n)/Math.log(2))) * (n**2 + n - 1);
let johnChenAnswer = (Math.floor((Math.log(n)/Math.log(2))) + 1) * (Math.ceil(((n**3-1)/n)) + n - 1);
let rayAnswer = (n ** 2 - 1) * Math.ceil(Math.log(n) / Math.log(2)) + n * (Math.log(n) / Math.log(2) + 1);

console.log("\nInput n = " + n);
console.log("\nCalculated elementary operations = " + count);
console.log("\nTutorial answer prediction = " + pastTutorialAnswer);
console.log("Daniel Answer = " + danielAnswer);
console.log("John Chen Answer = " + johnChenAnswer);
console.log("Raymond answer prediction = " + rayAnswer);

