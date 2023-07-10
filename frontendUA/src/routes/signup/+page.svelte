<script>
    let email = "";
    let username = "";
    let password = "";
    let confirmPassword = "";
  
    const Signup = (
    /** @type {{ preventDefault: () => void; }} */ event
  ) => {
    event.preventDefault();

    console.log(username, password);
    axios
      .post(
        "http://localhost:8080/signup",
        {
          username: username,
          email: email,
          password: password,
          confirmPassword: confirmPassword,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((res) => {
        console.log(res);
        // console.log("-----After This--------")
        // console.log(UserName)
      })
      .catch((err) => {
        console.log(err);
        console.log(err.message.reason);
      });

  };
  </script>
  
  <main class="min-h-screen flex items-center justify-center bg-blue-500 bg-opacity-50 backdrop-filter backdrop-blur-lg">
    <div class="bg-white p-8 rounded-md shadow-md max-w-md w-full">
      <h1 class="text-3xl font-bold mb-6">Sign Up</h1>
  
      <form>
        <div class="mb-4">
          <label class="block text-gray-700 text-sm font-bold mb-2" for="email">Email</label>
          <input class="bg-gray-100 appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="email" type="email" placeholder="Enter your email" bind:value="{email}">
        </div>
  
        <div class="mb-4">
          <label class="block text-gray-700 text-sm font-bold mb-2" for="username">Username</label>
          <input class="bg-gray-100 appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="username" type="text" placeholder="Choose a username" bind:value="{username}">
        </div>
  
        <div class="mb-4">
          <label class="block text-gray-700 text-sm font-bold mb-2" for="password">Password</label>
          <input class="bg-gray-100 appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="password" type="password" placeholder="Enter your password" bind:value="{password}">
        </div>
  
        <div class="mb-6">
          <label class="block text-gray-700 text-sm font-bold mb-2" for="confirmPassword">Confirm Password</label>
          <input class="bg-gray-100 appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="confirmPassword" type="password" placeholder="Confirm your password" bind:value="{confirmPassword}">
        </div>
  
        <div class="flex items-center justify-between mb-4">
          <a class="text-blue-500 hover:text-blue-700 text-sm" href="/login">Already have an account? Login</a>
        </div>
  
        <div class="flex items-center justify-between">
          <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" on:click="{Signup}">
            Sign Up
          </button>
        </div>
      </form>
    </div>
  </main>
  