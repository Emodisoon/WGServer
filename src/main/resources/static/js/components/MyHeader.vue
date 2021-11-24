<template>
  <v-app-bar
      color="blue"
      app
  >
    <v-toolbar-title><router-link class="mylynk" to="/">WGServer</router-link></v-toolbar-title>
    <v-spacer></v-spacer>
    <div class="mr-5">
      <router-link class="mylynk mx-3" to="/add">Добавить устройство</router-link>
      <router-link class="mylynk mx-3" to="/delete">Удалить устройство</router-link>
      <a class="mylynk mx-3" href="/logout">Выход</a>

    </div>
  </v-app-bar>
</template>

<script>
export default {
  name: "MyHeader"
}
</script>

<style scoped>
.mylynk{
  color: black;
}
</style>