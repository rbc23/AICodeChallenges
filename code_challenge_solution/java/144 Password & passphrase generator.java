let characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+~`|}{[]\:;?><,./-=";
let passwordLength = 12;
let password = '';

for(let i = 0; i < passwordLength; i++){
  let randomIndex = Math.floor(Math.random() * characterSet.length);
  password += characterSet[randomIndex];
}

console.log("Generated password:", password);