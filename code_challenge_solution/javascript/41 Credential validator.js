var regex = /^[A-Za-z0-9]+$/;

function validateCredential(credential) {
  if (regex.test(credential)) {
    console.log("Valid credential");
  } else {
    console.log("Invalid credential");
  }
}

// Example usage
validateCredential("abc123");