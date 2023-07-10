<script>
  import bgimage from '$lib/bg.png';
  
  let username = "";
  let password = "";

  const handleSubmit = (
    /** @type {{ preventDefault: () => void; }} */ event
  ) => {
    event.preventDefault();

    console.log(username, password);
    axios
      .post(
        "http://localhost:8080/login",
        {
          username: username,
          password: password,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      )
      .then((res) => {
        console.log(res);
        UserName = res.data.UserName;
        goto("/home");
        // console.log("-----After This--------")
        // console.log(UserName)
      })
      .catch((err) => {
        console.log(err);
        console.log(err.message.reason);
      });

  };

</script>

<main class="min-h-screen flex items-center justify-center">
  <div
    class="absolute inset-0 bg-cover bg-no-repeat bg-center z-0"
    style="background-image: url('static/bg.png'); filter: blur(10px);"
  />

  <div class="relative bg-white p-8 rounded-md shadow-md max-w-md w-full z-10">
    <h1 class="text-3xl font-bold mb-6">Login</h1>

    <form>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="username"
          >Username</label
        >
        <input
          class="bg-gray-100 appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="username"
          type="text"
          placeholder="Enter your username"
          bind:value={username}
        />
      </div>

      <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="password"
          >Password</label
        >
        <input
          class="bg-gray-100 appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="password"
          type="password"
          placeholder="Enter your password"
          bind:value={password}
        />
      </div>

      <div class="flex items-center mb-4">
        <p class="text-sm mr-1">Didn't register yet?</p>
        <a class="text-blue-500 hover:text-blue-700 text-sm" href="/signup"
          >Register</a
        >
      </div>

      <div class="flex items-center justify-between">
        <button
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
          on:click={handleSubmit}
        >
          Sign In
        </button>
      </div>
    </form>
  </div>
</main>

<style>
  main {
    position: relative;
  }

  main::before {
    content: "";
    position: absolute;
    inset: 0;
    z-index: -1;
    background-image: url({bgimage});
    filter: blur(10px);
  }
</style>
